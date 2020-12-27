package helpers;

import drivers.DriverResolvers;
import drivers.GridDriverResolver;
import drivers.LocalDriverResolver;
import drivers.SLDriverResolver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class  RunLocationDriver {

    private static RunLocationDriver instance;
    private ThreadLocal<WebDriver> tlDRiver = new ThreadLocal<>();
    private Map<String, DriverResolvers> driverResolversMap;
    private ConfigData data;
    private DriverResolvers resolver;

    private RunLocationDriver() {
        data = Utilities.getConfigData();
        driverResolversMap = new HashMap<>();
        driverResolversMap.put("local", new LocalDriverResolver());
        driverResolversMap.put("cloud", new SLDriverResolver());
        driverResolversMap.put("grid", new GridDriverResolver());
        resolver = driverResolversMap.get(data.getRun_location());
    }

    private static class SingletonHolder {
        private final static RunLocationDriver instance = new RunLocationDriver();
    }

    public static RunLocationDriver getInstance () {
        return SingletonHolder.instance;
    }

    public WebDriver getWebDriver(){
        WebDriver driver = null;
        if (tlDRiver.get() != null) {
            return tlDRiver.get();
        }
        switch (data.getBrowser()){
            case "chrome" :
                driver = resolver.initChromeWebDriver();
                break;
            case "firefox" :
                driver = resolver.initFFWebDriver();
                break;
        }
        tlDRiver.set(driver);
        return driver;
    }

    public void deleteDriver () {
        if (tlDRiver.get() != null) {
            tlDRiver.remove();
        }
    }
}
