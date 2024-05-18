package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement txtUsername=webDriver.findElement(By.id("user-name"));
    private WebElement txtPassword=webDriver.findElement(By.id("password"));
    private WebElement btnSignIn=webDriver.findElement(By.name("login-button"));

    public LoginPage enterEmail(String email){
        txtUsername.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        txtPassword.sendKeys(password);
        return this;
    }

    public void clickOnLoginButton() {
        btnSignIn.click();
    }

}
