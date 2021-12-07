package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static pages.locators.BasketPageLocators.BASKET_EMPTY_MESSAGE;
import static pages.locators.BasketPageLocators.BASKET_ITEMS;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void shouldBeEmpty() {
        Assert.assertTrue(isNotElementPresent(BASKET_ITEMS),"Basket is not empty");
    }

    public void shouldBeMessageAboutEmptiness() {
        Assert.assertTrue(isElementPresent(BASKET_EMPTY_MESSAGE),"Message about emptiness is not presented");
    }
}
