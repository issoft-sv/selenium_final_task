package drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SLDriverResolver extends DriverResolvers {

    @Override
    public WebDriver initChromeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return getDriverFromOptions(chromeOptions);
    }

    @Override
    public WebDriver initFFWebDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver();
    }

    private WebDriver getDriverFromOptions (MutableCapabilities mc) {
        mc.setCapability("platformName", "Windows 10");
        mc.setCapability("browserVersion", "latest");
        mc.setCapability("sauce:options", mc);
        return new RemoteWebDriver(buildSLUrl(), mc);
    }

    private URL buildSLUrl() {
        String username = System.getenv("sl_username");
        String access_key = System.getenv("sl_key");
        String url = "https://" + username + ":" + access_key + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
