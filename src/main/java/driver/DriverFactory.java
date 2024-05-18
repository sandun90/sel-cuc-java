package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public static WebDriver webDriver;

    public static WebDriver getNewInstance(String browserName) throws Exception {
            switch (browserName.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver= new FirefoxDriver();
                    break;
                default:
/*                    WebDriverManager.chromedriver().clearDriverCache().setup();
                    WebDriverManager.chromedriver().clearResolutionCache().setup();*/
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    webDriver= new ChromeDriver(options);
            }
        return webDriver;
    }




}
