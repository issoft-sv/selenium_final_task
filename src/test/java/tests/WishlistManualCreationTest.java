package tests;

import org.junit.jupiter.api.Test;
import pages.MyWishListPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistManualCreationTest extends BaseTest{
    @Test
    public void WishlistManualCreationTest () {
        String wishlistName = "my_wishlist";
        MyWishListPage myWishListPage = loginPage.signIn("sel_test@mailinator.com", "12345").getMyWishListPage();
        if (myWishListPage.doWishlistsExist()) myWishListPage.removeAllWishlists();
        myWishListPage.createWishlist(wishlistName);
        myWishListPage.getDressesCategory().addToWishlist(1).closeNotificationOfWishlist().getMyAccountPage().getMyWishListPage();
        assertAll(
                () -> assertTrue(myWishListPage.isWishlistCreated(wishlistName)),
                () -> assertTrue(myWishListPage.isWishlistNotEmpty())
        );
    }
}
