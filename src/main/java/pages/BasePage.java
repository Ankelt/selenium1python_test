package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;
import static pages.locators.BasePageLocators.*;


public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isNotElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return true;
        }
        return false;
    }

    public boolean isDisappeared(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void goToLoginPage() {
        WebElement login = driver.findElement(LOGIN_LINK);
        login.click();
    }

    public void shouldBeLoginLink() {
        Assert.assertTrue(isElementPresent(LOGIN_LINK), "Login link is not presented");
    }

    public void goToBasketPage() {
        WebElement basket = driver.findElement(BASKET_LINK);
        basket.click();
    }

    public void shouldBeAuthorised() {
        Assert.assertTrue(isElementPresent(USER_ICON),
                "User icon is not presented, probably unauthorised user");
    }
}
