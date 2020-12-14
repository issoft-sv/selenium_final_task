package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage extends HomePage{

    public MyWishListPage(WebDriver driver) {
        super(driver);
    }

    private By wishlistRecord;
    private By wishlistTable = By.xpath("//table");
    private By viewProductsButton = By.xpath("//a[contains(text(),'View')]");
    private By productImage = By.xpath("//div[@class='product_image']");
    private By wishlistNameField = By.xpath("//input[@id='name']");
    private By wishlistSaveButton = By.xpath("//button[@id='submitWishlist']");
    private By removeWishlistButton = By.xpath("//i[@class='icon-remove']");

    public Boolean isWishlistCreated (String wishlistName) {
        wishlistRecord = By.xpath(String.format("//table//a[contains(text(),'%s')]", wishlistName));
        Boolean isCreated = driver.findElements(wishlistRecord).size() > 0;
        return isCreated;
    }

    public Boolean doWishlistsExist () {
        Boolean doExist = driver.findElements(wishlistTable).size() > 0;
        return doExist;
    }

    public Boolean isWishlistNotEmpty () {
        driver.findElement(viewProductsButton).click();
        Boolean notEmpty = driver.findElements(productImage).size() > 0;
        return notEmpty;
    }

    public MyWishListPage createWishlist (String wishlistName) {
        driver.findElement(wishlistNameField).sendKeys(wishlistName);
        driver.findElement(wishlistSaveButton).click();
        return this;
    }

    public MyWishListPage removeAllWishlists () {
        for (WebElement we : driver.findElements(removeWishlistButton)) {
            we.click();
            driver.switchTo().alert().accept();
        }
        return this;
    }
}
