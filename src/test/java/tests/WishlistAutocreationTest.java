package tests;

import helpers.Utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.MyWishListPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistAutocreationTest extends BaseTest{

    @Feature("Wish list auto creation")
    @Description("Verify the app auto create wish list")
    @TestCaseId("41")
    @Test
    public void wishlistAutoCreation () {
        expected = Utilities.getValueFromJsonConfig("wishlist_auto", data_file);
        MyWishListPage myWishListPage = loginPage.signIn(email, password).getMyWishListPage();
        if (myWishListPage.doWishlistsExist()) myWishListPage.removeAllWishlists();
        myWishListPage.getDressesCategory().addToWishlist(1).closeNotificationOfWishlist().getMyAccountPage().getMyWishListPage();
        assertAll(
                () -> assertTrue(myWishListPage.isWishlistCreated(expected)),
                () -> assertTrue(myWishListPage.isWishlistNotEmpty())
        );
    }
}
