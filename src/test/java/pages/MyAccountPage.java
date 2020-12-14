package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends HomePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private By myWishListsButton = By.xpath("//a[@title='My wishlists']");

    public MyWishListPage getMyWishListPage () {
        driver.findElement(myWishListsButton).click();
        return new MyWishListPage(driver);
    }


}
