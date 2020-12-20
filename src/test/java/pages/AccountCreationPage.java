package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BasePage {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "id_state")
    private WebElement stateField;
    @FindBy(xpath = "//select[@id='id_state']/option[3]")
    private WebElement stateDropDown;
    @FindBy(id = "postcode")
    private WebElement postalCodeField;
    @FindBy(id = "id_country")
    private WebElement countryField;
    @FindBy(xpath = "//select[@id='id_country']/option[text()='United States']")
    private WebElement countryDropDown;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    @FindBy(id = "alias")
    private WebElement addressAliasField;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement firstnameRequiredError;

    public MyAccountPage createAccount (String firstname, String lastname, String password, String address, String city, String postalcode, String mobilephone, String alias) {
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        passwordField.sendKeys(password);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        stateField.click();
        stateDropDown.click();
        postalCodeField.sendKeys(postalcode);
        countryField.click();
        countryDropDown.click();
        mobilePhoneField.sendKeys(mobilephone);
        addressAliasField.sendKeys(alias);
        registerButton.click();
        return PageFactory.initElements(driver, MyAccountPage.class);
    }

    public String getErrorText () {
        return firstnameRequiredError.getText();
    }
}
