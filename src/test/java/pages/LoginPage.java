package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    private WebElement emailFieldForSignUp;
    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;
    @FindBy(id = "email")
    private WebElement emailFieldForSignIn;
    @FindBy(id = "passwd")
    private WebElement passwordFieldForSignIn;
    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;
    @FindBy(id = "create_account_error")
    private WebElement createAccountError;

    public AccountCreationPage submitEmailForSignUp (String email) {
        emailFieldForSignUp.sendKeys(email);
        createAccountButton.click();
        return PageFactory.initElements(driver, AccountCreationPage.class);
    }

    public MyAccountPage signIn (String email, String pwd) {
        emailFieldForSignIn.sendKeys(email);
        passwordFieldForSignIn.sendKeys(pwd);
        signInButton.click();
        return PageFactory.initElements(driver, MyAccountPage .class);
    }

    public String getErrorText () {
        String dd = createAccountError.getText();
        return dd;
    }
}
