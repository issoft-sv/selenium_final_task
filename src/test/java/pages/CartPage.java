package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends HomePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productInCart = By.xpath("//tr[contains(@id,'product')]");
    private By productsTable = By.xpath("//table[@id='cart_summary']");
    private By deleteFromCartButton = By.xpath("//a[@title='Delete']");


    public Boolean cartContentIsCorrect (int expectedProductsNumber) {
        Boolean isCorrect = driver.findElements(productInCart).size() == expectedProductsNumber;
        return isCorrect;
    }

    public Boolean cartTotalIsCorrect (int expectedProductsNumber) {
        double totalPriceActual = 0;
        for (int i=1; i<=expectedProductsNumber; i++){
            By totalForProduct = By.xpath(String.format("//tr[contains(@id,'product')][%d]/td[@class='cart_total']//span[@class='price']", i));
            String total = driver.findElement(totalForProduct).getText().substring(1);
            totalPriceActual = totalPriceActual + Double.valueOf(total);
        }
        By cartTotalField = By.xpath("//tr[@class='cart_total_price']/td[@id='total_product']");
        String total = driver.findElement(cartTotalField).getText();
        double cartTotal = Double.parseDouble(total.substring(1));
        Boolean isCorrect = Math.abs(totalPriceActual - cartTotal)<0.001;
        return isCorrect;
    }

    public CartPage removeAllFromCart () {
        getCartPage();
        for (WebElement we : driver.findElements(deleteFromCartButton)) {
            we.click();
        }
        return this;
    }

    public Boolean cartIsNotEmpty () {
        Boolean notEmpty = driver.findElements(productsTable).size() > 0;
        return notEmpty;
    }
}
