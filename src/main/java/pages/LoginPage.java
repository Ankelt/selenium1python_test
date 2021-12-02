package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static pages.locators.LoginPageLocators.LOGIN_FORM;
import static pages.locators.LoginPageLocators.REGISTER_FORM;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void shouldBeLoginPage() {
        shouldBeLoginUrl();
        shouldBeLoginForm();
        shouldBeRegisterForm();
    }

    public void shouldBeLoginUrl() {
        String current_url = driver.getCurrentUrl();
        Assert.assertTrue("\'login\' is not presented in current URL", current_url.contains("login"));
    }

    public void shouldBeLoginForm() {
        Assert.assertTrue("Login form is not presented", isElementPresent(LOGIN_FORM));
    }

    public void shouldBeRegisterForm() {
        Assert.assertTrue("Register form is not presented", isElementPresent(REGISTER_FORM));
    }
}
