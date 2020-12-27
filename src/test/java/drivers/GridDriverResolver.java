package drivers;

import helpers.ConfigData;
import helpers.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriverResolver extends DriverResolvers {

    @Override
    public WebDriver initChromeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return new RemoteWebDriver(buildGridUrl(), chromeOptions);
    }

    @Override
    public WebDriver initFFWebDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new RemoteWebDriver(buildGridUrl(), firefoxOptions);
    }

    private URL buildGridUrl() {
        ConfigData cd = Utilities.getConfigData();
        String url = "https://" + cd.getGrid_host() + ":" + cd.getGrid_port();
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
