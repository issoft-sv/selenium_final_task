package helpers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.ByteArrayInputStream;

public class Listener implements TestWatcher {

    private WebDriver driver = RunLocationDriver.getInstance().getWebDriver();
    private Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        Allure.addAttachment("Date&Time", Utilities.getActualDate());
        Allure.addAttachment("Browser", cap.getBrowserName());
        Allure.addAttachment("Platform", cap.getPlatformName().toString());
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
