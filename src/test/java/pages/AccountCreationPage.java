package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage extends HomePage{

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameField = By.xpath("//input[@id='customer_firstname']");
    private By lastNameField = By.xpath("//input[@id='customer_lastname']");
    private By passwordField = By.xpath("//input[@id='passwd']");
    private By addressField = By.xpath("//input[@id='address1']");
    private By cityField = By.xpath("//input[@id='city']");
    private By stateField = By.xpath("//select[@id='id_state']");
    private By stateDropDown = By.xpath("//select[@id='id_state']/option[3]");
    private By postalCodeField = By.xpath("//input[@id='postcode']");
    private By countryField = By.xpath("//select[@id='id_country']");
    private By countryDropDown = By.xpath("//select[@id='id_country']/option[text()='United States']");
    private By mobilePhoneField = By.xpath("//input[@id='phone_mobile']");
    private By addressAliasField = By.xpath("//input[@id='alias']");
    private By registerButton = By.xpath("//button[@id='submitAccount']");
    private By firstnameRequiredError = By.xpath("//li[contains(text(),'is required')]/b[text()='firstname']");

    public MyAccountPage createAccount (String firstname, String lastname, String password, String address, String city, String postalcode, String mobilephone, String alias) {
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).click();
        driver.findElement(stateDropDown).click();
        driver.findElement(postalCodeField).sendKeys(postalcode);
        driver.findElement(countryField).click();
        driver.findElement(countryDropDown).click();
        driver.findElement(mobilePhoneField).sendKeys(mobilephone);
        driver.findElement(addressAliasField).sendKeys(alias);
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }

    public Boolean isFirstnameRequiredErrorDisplayed () {
        return driver.findElements(firstnameRequiredError).size() > 0;
    }
}
