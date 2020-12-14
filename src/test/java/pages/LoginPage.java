package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HomePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailFieldForSignUp = By.xpath("//input[@id='email_create']");
    private By createAccountButton = By.xpath("//button[@id='SubmitCreate']");
    private By emailFieldForSignIn = By.xpath("//input[@id='email']");
    private By passwordFieldForSignIn = By.xpath("//input[@id='passwd']");
    private By signInButton = By.xpath("//button[@id='SubmitLogin']");
    private By invalidEmailError = By.xpath("//li[text()='Invalid email address.']");
    private By existingEmailError = By.xpath("//li[contains(text(),'already been registered')]");
    private By emailRequiredError = By.xpath("//li[text()='An email address required.']");
    private By passowrdRequiredError = By.xpath("//li[text()='Password is required.']");

    public AccountCreationPage submitEmailForSignUp (String email) {
        driver.findElement(emailFieldForSignUp).sendKeys(email);
        driver.findElement(createAccountButton).click();
        return new AccountCreationPage(driver);
    }

    public MyAccountPage signIn (String email, String pwd) {
        driver.findElement(emailFieldForSignIn).sendKeys(email);
        driver.findElement(passwordFieldForSignIn).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new MyAccountPage(driver);
    }

    public Boolean isInvalidEmailErrorDisplayed () {
        return driver.findElements(invalidEmailError).size() > 0;
    }

    public Boolean isExistingEmailErrorDisplayed () {
        return driver.findElements(existingEmailError).size() > 0;
    }

    public Boolean isEmailRequiredErrorDisplayed () {
        return driver.findElements(emailRequiredError).size() > 0;
    }

    public Boolean isPassowrdRequiredErrorDisplayed () {
        return driver.findElements(passowrdRequiredError).size() > 0;
    }
}
