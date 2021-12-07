package pages.locators;

import org.openqa.selenium.By;

public class BasketPageLocators {
    public static final By BASKET_ITEMS = By.cssSelector("#content_inner .basket-title");
    public static final By BASKET_EMPTY_MESSAGE = By.cssSelector("#content_inner > p");
}
