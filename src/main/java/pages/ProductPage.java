package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static pages.locators.ProductPageLocators.*;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void addProductToBasket() {
        WebElement basket_button = driver.findElement(BASKET_BUTTON);
        basket_button.click();
    }

    public void shouldBeCorrectAdding() {
        shouldBeMessageAboutAddingToBasket();
        shouldBeEqualPriceForBasketAndProduct();
    }

    public void shouldBeEqualPriceForBasketAndProduct() {
        WebElement price = driver.findElement(PRODUCT_PRICE);
        WebElement basket = driver.findElement(PRICE_IN_BASKET);
        String priceText = price.getText();
        String basketText = basket.getText();
        Assert.assertEquals(priceText, basketText,
                String.format("Product price %s is not same with in basket (%s)", priceText, basketText));
    }

    public void shouldBeMessageAboutAddingToBasket() {
        WebElement product = driver.findElement(PRODUCT_NAME);
        WebElement productInBasket = driver.findElement(PRODUCT_IN_BASKET_NAME);
        String productName = product.getText();
        String productInBasketName = productInBasket.getText();
        Assert.assertEquals(productName, productInBasketName,
                String.format("Product name %s is not same with %s name in basket", productName, productInBasketName));
    }

    public void successMessageIsDisappeared() {
        Assert.assertTrue(isDisappeared(SUCCESS_MESSAGE));
    }

    public void shouldBeSuccessMessage() {
        Assert.assertTrue(isElementPresent(SUCCESS_MESSAGE));
    }

    public void shouldNotBeSuccessMessage() {
        Assert.assertTrue(isNotElementPresent(SUCCESS_MESSAGE));
    }
}
