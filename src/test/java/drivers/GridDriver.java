package drivers;

import helpers.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() throws MalformedURLException {
        switch (Utilities.getValueFromJsonConfig("browser", "config.xml")) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                break;
        }
        return driver;
    }
}
