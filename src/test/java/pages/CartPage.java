package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "total_product")
    private WebElement cartTotalField;
    @FindBy(xpath = "//tr[contains(@id,'product')]")
    private List<WebElement> productInCart;
    @FindBy(id = "cart_summary")
    private List<WebElement> productsTable;
    @FindBy(xpath = "//a[@title='Delete']")
    private List<WebElement> deleteFromCartButton;


    public Boolean cartContentIsCorrect (int expectedProductsNumber) {
        Boolean isCorrect = productInCart.size() == expectedProductsNumber;
        return isCorrect;
    }

    public Boolean cartTotalIsCorrect (int expectedProductsNumber) {
        double totalPriceActual = 0;
        for (int i=1; i<=expectedProductsNumber; i++){
            By totalForProduct = By.xpath(String.format("//tr[contains(@id,'product')][%d]/td[@class='cart_total']//span[@class='price']", i));
            String total = driver.findElement(totalForProduct).getText().substring(1);
            totalPriceActual = totalPriceActual + Double.valueOf(total);
        }
        String total = cartTotalField.getText();
        double cartTotal = Double.parseDouble(total.substring(1));
        Boolean isCorrect = Math.abs(totalPriceActual - cartTotal)<0.001;
        return isCorrect;
    }

    public CartPage removeAllFromCart () {
        getCartPage();
        for (WebElement we : deleteFromCartButton) {
            we.click();
        }
        return this;
    }

    public Boolean cartIsNotEmpty () {
        Boolean notEmpty = productsTable.size() > 0;
        return notEmpty;
    }
}
