package helpers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.BaseTest;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Listener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        Capabilities cap = ((RemoteWebDriver) BaseTest.getDriver()).getCapabilities();
        Allure.addAttachment("Date&Time", strDate);
        Allure.addAttachment("Browser", cap.getBrowserName());
        Allure.addAttachment("Platform", cap.getPlatformName().toString());
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
