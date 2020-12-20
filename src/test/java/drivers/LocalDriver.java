package drivers;

import helpers.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver {

    private static ThreadLocal<WebDriver> tlDRiver = new ThreadLocal<>();
    private static WebDriver driver;

    public static WebDriver getDriver() {
        initDriver();
        return driver;
    }

    public static void initDriver () {
        if (tlDRiver.get() != null) {
            driver = tlDRiver.get();
            return;
        }
        driver = selectBrowser();
        tlDRiver.set(driver);
    }

    public static void deleteDriver () {
        if (tlDRiver.get() != null) {
            tlDRiver.remove();
        }
    }

    private static WebDriver selectBrowser () {
        switch (Utilities.getValueFromJsonConfig("browser", "config.xml")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
