package stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import driver.DriverHolder;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class StepDefinitionLogin {

    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void setup()throws Throwable {
        driver = DriverFactory.getNewInstance("chrome");
        DriverHolder.setDriver(driver);
        // open the given url
        driver.manage().window().maximize();
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String url) throws Throwable {
        // open the given url
        driver.get(url);
        loginPage=new LoginPage(driver);
    }

    @When("^Login using user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login_using_user_name_and_password(String username, String password) throws Throwable {
        loginPage.enterEmail(username).enterPassword(password).clickOnLoginButton();
    }

    @Then("^User should get successfully logged in$")
    public void user_should_get_successfully_logged_in() throws Throwable {
        homePage=new HomePage(driver);
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.homePageLoaded());
    }

    @After
    public void quitBrowser(){
        driver.quit();
    }

}
