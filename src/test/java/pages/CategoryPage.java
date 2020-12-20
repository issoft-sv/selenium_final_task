package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton;
    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;
    private By productBlock;
    private By addToWishlistButton;
    @FindBy(xpath = "//a[@title='Close']")
    private WebElement closeNotificationButton;

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
        closeNotificationButton.click();
        return this;
    }

    public CategoryPage addToCart (int productNumber) {
        navigateToProduct(productNumber);
        addToCartButton = By.xpath(String.format("//li[contains(@class,'ajax_block_product')][%d]//a[@title='Add to cart']", productNumber));
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CategoryPage closeNotificationOfCart () {
        continueShoppingButton.click();
        return this;
    }
}
