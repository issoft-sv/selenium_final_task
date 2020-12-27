package tests;

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
        expected = data.getMy_account_tab();
        loginPage.signIn(email, password);
        Assertions.assertEquals(expected, loginPage.getTabName());
    }

    @Feature("Login")
    @Description("Verify it's impossible to login with empty email/password fields")
    @TestCaseId("12")
    @Test
    public void loginWithEmptyFields () {
        expected = data.getEmail_required();
        loginPage.signIn("", "");
        assertEquals(expected, loginPage.getErrorText());
    }

    @Feature("Login")
    @Description("Verify it's impossible to login with empty password field")
    @TestCaseId("13")
    @Test
    public void loginWithEmptyPasswordField () {
        expected = data.getPassword_required();
        loginPage.signIn(email, "");
        assertEquals(expected, loginPage.getErrorText());
    }
}
