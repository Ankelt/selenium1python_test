package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;
import static pages.locators.LoginPageLocators.*;

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

    public void registerNewUser(String email, String password) {
        WebElement emailForm = driver.findElement(EMAIL_FORM);
        emailForm.sendKeys(email);
        WebElement passwordForm = driver.findElement(PASSWORD_FORM);
        passwordForm.sendKeys(password);
        WebElement passwordFormRepeat = driver.findElement(PASSWORD_FORM_REPEAT);
        passwordFormRepeat.sendKeys(password);
        WebElement button = driver.findElement(REGISTER_BUTTON);
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    }
}
