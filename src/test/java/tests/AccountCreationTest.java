package tests;

import helpers.Utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.AccountCreationPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountCreationTest extends BaseTest{

    private String randomDate = Utilities.getActualDate();

    @Feature("Account creation")
    @Description("Verify it's impossible to register new user")
    @TestCaseId("21")
    @Test
    public void regWithValidValues () {
        expected = Utilities.getValueFromJsonConfig("my_account_tab", data_file);
        loginPage.submitEmailForSignUp(randomDate + "@mailinator.com").createAccount("fn", "ln", randomDate, randomDate, randomDate, "12345", "+375291111111", randomDate);
        assertEquals(expected, loginPage.getTabName());
    }

    @Feature("Account creation")
    @Description("Verify it's impossible to register new user with invalid email")
    @TestCaseId("22")
    @Test
    public void regWithInvalidEmail () {
        expected = Utilities.getValueFromJsonConfig("invalid_email", data_file);
        loginPage.submitEmailForSignUp("@mailinator.com");
        assertEquals(expected, loginPage.getErrorText());
    }

    @Feature("Account creation")
    @Description("Verify it's impossible to register new user with empty name field")
    @TestCaseId("23")
    @Test
    public void regWithEmptyNameField () {
        AccountCreationPage accountCreationPage = loginPage.submitEmailForSignUp(randomDate + "@mailinator.com");
        accountCreationPage.createAccount("", "lastname", randomDate, randomDate, randomDate, "12345", "+375291111111", randomDate);
        assertTrue(accountCreationPage.getErrorText().contains("firstname is required."));
    }
}
