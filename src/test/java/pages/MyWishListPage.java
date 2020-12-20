package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyWishListPage extends BasePage {

    public MyWishListPage(WebDriver driver) {
        super(driver);
    }

    private By wishlistRecord;
    @FindBy(xpath = "//table")
    private List<WebElement> wishlistTable;
    @FindBy(xpath = "//a[contains(text(),'View')]")
    private WebElement viewProductsButton;
    @FindBy(className = "product_image")
    private List<WebElement> productImage;
    @FindBy(id = "name")
    private WebElement wishlistNameField;
    @FindBy(id = "submitWishlist")
    private WebElement wishlistSaveButton;
    @FindBy(className = "icon-remove")
    private List<WebElement> removeWishlistButton;

    public Boolean isWishlistCreated (String wishlistName) {
        wishlistRecord = By.xpath(String.format("//table//a[contains(text(),'%s')]", wishlistName));
        Boolean isCreated = driver.findElements(wishlistRecord).size() > 0;
        return isCreated;
    }

    public Boolean doWishlistsExist () {
        Boolean doExist = wishlistTable.size() > 0;
        return doExist;
    }

    public Boolean isWishlistNotEmpty () {
        viewProductsButton.click();
        Boolean notEmpty = productImage.size() > 0;
        return notEmpty;
    }

    public MyWishListPage createWishlist (String wishlistName) {
        wishlistNameField.sendKeys(wishlistName);
        wishlistSaveButton.click();
        return this;
    }

    public MyWishListPage removeAllWishlists () {
        for (WebElement we : removeWishlistButton) {
            we.click();
            driver.switchTo().alert().accept();
        }
        return this;
    }
}
