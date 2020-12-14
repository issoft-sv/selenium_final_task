package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AccountCreationPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AccountCreationTest extends BaseTest{

    private String randomDate;

    @Test
    public void regWithValidValues () {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        randomDate = dateFormat.format(date).replace(":", "");
        loginPage.submitEmailForSignUp(randomDate + "@mailinator.com").createAccount("fn", "ln", randomDate, randomDate, randomDate, "12345", "+375291111111", randomDate);
        Assertions.assertEquals(loginPage.getTabName(), "My account - My Store");
    }

    @Test
    public void regWithInvalidEmail () {
        loginPage.submitEmailForSignUp("@mailinator.com");
        Assertions.assertTrue(loginPage.isInvalidEmailErrorDisplayed());
    }

    @Test
    public void regWithExistingEmail () {
        loginPage.submitEmailForSignUp("sel_test@mailinator.com");
        Assertions.assertTrue(loginPage.isExistingEmailErrorDisplayed());
    }

    @Test
    public void regWithEmptyNameField () {
        AccountCreationPage accountCreationPage = loginPage.submitEmailForSignUp(randomDate + "@mailinator.com");
        accountCreationPage.createAccount(" ", "lastname", randomDate, randomDate, randomDate, "12345", "+375291111111", randomDate);
        Assertions.assertTrue(accountCreationPage.isFirstnameRequiredErrorDisplayed());
    }
}
