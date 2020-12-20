package tests;

import helpers.Utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest{


    @Feature("Login")
    @Description("Verify it's possible to login with valid creds")
    @TestCaseId("11")
    @Test
    public void loginWithValidCredentials () {
        expected = Utilities.getValueFromJsonConfig("my_account_tab", data_file);
        loginPage.signIn(email, password);
        Assertions.assertEquals(expected, loginPage.getTabName());
    }

    @Feature("Login")
    @Description("Verify it's impossible to login with empty email/password fields")
    @TestCaseId("12")
    @Test
    public void loginWithEmptyFields () {
        expected = Utilities.getValueFromJsonConfig("email_required", data_file);
        loginPage.signIn("", "");
        assertEquals(expected, loginPage.getErrorText());
    }

    @Feature("Login")
    @Description("Verify it's impossible to login with empty password field")
    @TestCaseId("13")
    @Test
    public void loginWithEmptyPasswordField () {
        expected = Utilities.getValueFromJsonConfig("password_required", data_file);
        loginPage.signIn(email, "");
        assertEquals(expected, loginPage.getErrorText());
    }
}
