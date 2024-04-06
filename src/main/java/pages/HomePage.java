package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement homePageHeader=webDriver.findElement(By.xpath("//div[@class='app_logo' and text()='Swag Labs']"));

    public boolean homePageLoaded() throws InterruptedException {
        return homePageHeader.isDisplayed();
    }

}
