package pages.locators;

import org.openqa.selenium.By;

public class BasketPageLocators {
    public static final By BASKET_ITEMS = By.cssSelector("#content_inner .basket-title");
    public static final By BASKET_EMPTY_MESSAGE = By.cssSelector("#content_inner > p");
    public static final By AMOUNT_OF_BOOKS = By.id("id_form-0-quantity");
    public static final By REFRESH_BUTTON = By.cssSelector("div.col-sm-3 button");
}
