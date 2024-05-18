package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
        loginPage=new LoginPage(driver);
    }

    @When("Login using user name {string} and password {string}")
    public void login_using_user_name_and_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterEmail(username).enterPassword(password).clickOnLoginButton();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        homePage=new HomePage(driver);
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.homePageLoaded());
    }

    @After
    public void quitBrowser(){
        driver.quit();
    }

}
