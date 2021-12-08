package pages.locators;

import org.openqa.selenium.By;

public class ProductPageLocators {
    public static final By BASKET_BUTTON = By.cssSelector("button.btn-add-to-basket");
    public static final By PRODUCT_PRICE = By.cssSelector(".col-sm-6 > .price_color");
    public static final By PRICE_IN_BASKET = By.cssSelector(".alert-info > .alertinner > p > strong");
    public static final By PRODUCT_NAME = By.cssSelector(".col-sm-6 > h1");
    public static final By PRODUCT_IN_BASKET_NAME = By.xpath("//div[@id='messages']/div[1]/div/strong");
    public static final By SUCCESS_MESSAGE = By.cssSelector(".alert-success> .alertinner");
}
