package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage extends BasePage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement homePageHeader=webDriver.findElement(By.xpath("//div[@class='app_logo' and text()='Swag Labs']"));
/*WebElement xxx=webDriver.findElement(RelativeLocator.with(
        By.tagName("")
).below(homePageHeader)
);*/
    public boolean homePageLoaded() {
        return homePageHeader.isDisplayed();
    }

}
