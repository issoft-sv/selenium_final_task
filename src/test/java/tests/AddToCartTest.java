package tests;

import org.junit.jupiter.api.Test;
import pages.CartPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartTest extends BaseTest{

    @Test
    public void addToCart () {
        CartPage cp = loginPage.signIn("sel_test@mailinator.com", "12345").getCartPage();
        if (cp.cartIsNotEmpty()) cp.removeAllFromCart();
        for (int i=1; i<4; i++) cp.getDressesCategory().addToCart(i).closeNotificationOfCart();
        cp.getCartPage();
        assertAll(
                () -> assertTrue(cp.cartContentIsCorrect(3)),
                () -> assertTrue(cp.cartTotalIsCorrect(3))
        );
    }
}
