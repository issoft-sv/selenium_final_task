package tests;

import org.junit.jupiter.api.Test;
import pages.MyWishListPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistAutocreationTest extends BaseTest{

    @Test
    public void wishlistAutoCreation () {
        MyWishListPage myWishListPage = loginPage.signIn("sel_test@mailinator.com", "12345").getMyWishListPage();
        if (myWishListPage.doWishlistsExist()) myWishListPage.removeAllWishlists();
        myWishListPage.getDressesCategory().addToWishlist(1).closeNotificationOfWishlist().getMyAccountPage().getMyWishListPage();
        assertAll(
                () -> assertTrue(myWishListPage.isWishlistCreated("My wishlist")),
                () -> assertTrue(myWishListPage.isWishlistNotEmpty())
        );
    }
}
