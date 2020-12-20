package drivers;

import helpers.Utilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() throws MalformedURLException {
        String username = "se.rgey";
        String access_key = "389efb86-80a3-4108-91b2-780ac55b4199";
        String url = "https://" + username + ":" + access_key + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        MutableCapabilities sauceOptions = new MutableCapabilities();
        switch (Utilities.getValueFromJsonConfig("browser", "config.xml")) {
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("platformName", "Windows 10");
                chromeOptions.setCapability("browserVersion", "latest");
                chromeOptions.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(url), chromeOptions);
                break;
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platformName", "Windows 10");
                firefoxOptions.setCapability("browserVersion", "latest");
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(url), firefoxOptions);
                break;
        }
        return driver;
    }
}
