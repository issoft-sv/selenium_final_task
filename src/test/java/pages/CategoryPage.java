package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CategoryPage extends HomePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton;
    private By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
    private By productBlock = By.xpath("//li[contains(@class,'ajax_block_product')]");
    private By addToWishlistButton;
    private By closeNotificationButton = By.xpath("//a[@title='Close']");

    private void navigateToProduct (int productNumber ) {
        Actions action = new Actions(driver);
        productBlock = By.xpath(String.format("//li[contains(@class,'ajax_block_product')][%d]", productNumber));
        action.moveToElement(driver.findElement(productBlock)).build().perform();
    }

    public CategoryPage addToWishlist (int productNumber) {
        navigateToProduct(productNumber);
        addToWishlistButton = By.xpath(String.format("//li[contains(@class,'ajax_block_product')][%d]//div[@class='wishlist']/a", productNumber));
        driver.findElement(addToWishlistButton).click();
        return this;
    }

    public CategoryPage closeNotificationOfWishlist () {
        driver.findElement(closeNotificationButton).click();
        return this;
    }

    public CategoryPage addToCart (int productNumber) {
        navigateToProduct(productNumber);
        addToCartButton = By.xpath(String.format("//li[contains(@class,'ajax_block_product')][%d]//a[@title='Add to cart']", productNumber));
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CategoryPage closeNotificationOfCart () {
        driver.findElement(continueShoppingButton).click();
        return this;
    }
}
