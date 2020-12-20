package tests;

import helpers.Utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.MyWishListPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistManualCreationTest extends BaseTest{

    @Feature("Login")
    @Description("Verify it's possible to create wish list manually")
    @TestCaseId("51")
    @Test
    public void WishlistManualCreationTest () {
        expected = Utilities.getValueFromJsonConfig("wishlist_manual", data_file);
        MyWishListPage myWishListPage = loginPage.signIn(email, password).getMyWishListPage();
        if (myWishListPage.doWishlistsExist()) myWishListPage.removeAllWishlists();
        myWishListPage.createWishlist(expected);
        myWishListPage.getDressesCategory().addToWishlist(1).closeNotificationOfWishlist().getMyAccountPage().getMyWishListPage();
        assertAll(
                () -> assertTrue(myWishListPage.isWishlistCreated(expected)),
                () -> assertTrue(myWishListPage.isWishlistNotEmpty())
        );
    }
}
