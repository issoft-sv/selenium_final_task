package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By dressesButton = By.xpath("//div[@id='block_top_menu']/ul/li/a[text()='Dresses']");
    private By myAccountButton = By.xpath("//a[@title='View my customer account']");
    private By CartButton = By.xpath("//a[@title='View my shopping cart']");
    private By signOutButton = By.xpath("//a[@class='logout']");

    public CategoryPage getDressesCategory () {
        driver.findElement(dressesButton).click();
        return new CategoryPage(driver);
    }

    public MyAccountPage getMyAccountPage () {
        driver.findElement(myAccountButton).click();
        return new MyAccountPage(driver);
    }


    public CartPage getCartPage () {
        driver.findElement(CartButton).click();
        return new CartPage(driver);
    }

    public String getTabName () {
        return driver.getTitle();
    }

    public LoginPage signOut () {
        driver.findElement(signOutButton).click();
        return new LoginPage(driver);
    }
}
