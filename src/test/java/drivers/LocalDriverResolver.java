package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverResolver extends DriverResolvers {

    @Override
    public WebDriver initChromeWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Override
    public WebDriver initFFWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
