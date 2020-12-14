package tests;

import helpers.Listener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

@ExtendWith(Listener.class)
public class BaseTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    protected static LoginPage loginPage;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    public static void start () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @BeforeEach
    public void clearStart () {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    @AfterEach
    public void clearFinish () {
        try {
            loginPage.signOut();
        } catch (NoSuchElementException e) {}
    }

    @AfterAll
    public static void finish () {
        driver.quit();
        driver = null;
    }
}
