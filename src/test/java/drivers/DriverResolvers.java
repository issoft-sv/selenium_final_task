package drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverResolvers{
    public abstract WebDriver initChromeWebDriver();
    public abstract WebDriver initFFWebDriver();
}