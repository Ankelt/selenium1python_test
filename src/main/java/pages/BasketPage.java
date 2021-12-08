package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static pages.locators.BasketPageLocators.*;

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

    public void empty() {
        if (isElementPresent(AMOUNT_OF_BOOKS)) {
            WebElement amount = driver.findElement(AMOUNT_OF_BOOKS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                    amount,
                    "value",
                    "0");
            WebElement refreshButton = driver.findElement(REFRESH_BUTTON);
            refreshButton.click();
        }
    }
}
