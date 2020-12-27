package tests;

import helpers.ConfigData;
import helpers.Listener;
import helpers.RunLocationDriver;
import helpers.Utilities;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.time.Duration;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected ConfigData data;
    private WebDriver driver;
    protected LoginPage loginPage;
    protected String email;
    protected String password;
    protected String expected;

    public BaseTest () {
        data = Utilities.getConfigData();
        email = data.getValidemail();
        password = data.getValidpassword();
    }


    @BeforeAll
    public void start () {
        driver = RunLocationDriver.getInstance().getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @BeforeEach
    public void clearStart () {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("Current"+Thread.currentThread().getId());
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
        RunLocationDriver.getInstance().deleteDriver();
    }
}
