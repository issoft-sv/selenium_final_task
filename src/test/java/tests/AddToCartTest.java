package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartTest extends BaseTest{

    @Feature("Add to cart")
    @Description("Verify it's possible to add to cart any product")
    @TestCaseId("31")
    @Test
    public void addToCart () {
        CartPage cp = loginPage.signIn(email, password).getCartPage();
        if (cp.cartIsNotEmpty()) cp.removeAllFromCart();
        for (int i=1; i<4; i++) cp.getDressesCategory().addToCart(i).closeNotificationOfCart();
        cp.getCartPage();
        assertAll(
                () -> assertTrue(cp.cartContentIsCorrect(3)),
                () -> assertTrue(cp.cartTotalIsCorrect(3))
        );
    }
}
