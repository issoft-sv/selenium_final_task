package tests;

import drivers.LocalDriver;
import helpers.Listener;
import helpers.RunLocation;
import helpers.Utilities;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    protected LoginPage loginPage;
    protected String data_file = "test_data.xml";
    protected String email = Utilities.getValueFromJsonConfig("validemail", data_file);
    protected String password = Utilities.getValueFromJsonConfig("validpassword", data_file);
    protected String expected;

    @BeforeAll
    public void start () {
        driver = RunLocation.getRunLocationDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
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
    public void finish () {
        driver.quit();
        driver = null;
        if ((Utilities.getValueFromJsonConfig("run_location", "config.xml")).equals("local")) LocalDriver.deleteDriver();
    }
}
