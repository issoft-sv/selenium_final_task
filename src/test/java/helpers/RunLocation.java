package helpers;

import drivers.CloudDriver;
import drivers.GridDriver;
import drivers.LocalDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class RunLocation {

    static WebDriver driver;

    public static WebDriver getRunLocationDriver () {
        switch (Utilities.getValueFromJsonConfig("run_location", "config.xml")) {
            case "local" :
                driver = LocalDriver.getDriver();
                break;
            case "grid" :
                try {
                    driver = GridDriver.getDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "saucelabs" :
                try {
                    driver = CloudDriver.getDriver();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
        return driver;
    }
}
