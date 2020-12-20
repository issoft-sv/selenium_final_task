package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='My wishlists']")
    private WebElement myWishListsButton;

    public MyWishListPage getMyWishListPage () {
        myWishListsButton.click();
        return PageFactory.initElements(driver, MyWishListPage.class);
    }


}
