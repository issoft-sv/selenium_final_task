package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[text()='Dresses']")
    private WebElement dressesButton;
    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartButton;
    @FindBy(className = "logout")
    private WebElement signOutButton;

    public CategoryPage getDressesCategory () {
        dressesButton.click();
        return new CategoryPage(driver);
    }

    public MyAccountPage getMyAccountPage () {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }


    public CartPage getCartPage () {
        cartButton.click();
        return new CartPage(driver);
    }

    public String getTabName () {
        return driver.getTitle();
    }

    public LoginPage signOut () {
        signOutButton.click();
        return new LoginPage(driver);
    }
}
