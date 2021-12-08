package pages.locators;

import org.openqa.selenium.By;

public class BasePageLocators {
    public static final By LOGIN_LINK = By.id("login_link");
    public static final By BASKET_LINK = By.cssSelector(".basket-mini .btn-group .btn");
    public static final By USER_ICON = By.cssSelector(".icon-user");
    public static final By LOGOUT_LINK = By.id("logout_link");
}
