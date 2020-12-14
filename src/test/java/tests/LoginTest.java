package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentials () {
        loginPage.signIn("sel_test@mailinator.com", "12345");
        Assertions.assertEquals(loginPage.getTabName(), "My account - My Store");
    }

    @Test
    public void loginWithEmptyFields () {
        loginPage.signIn("", "");
        Assertions.assertTrue(loginPage.isEmailRequiredErrorDisplayed());
    }

    @Test
    public void loginWithEmptyPasswordField () {
        loginPage.signIn("sel-test@mailinator.com", "");
        Assertions.assertTrue(loginPage.isPassowrdRequiredErrorDisplayed());
    }
}
