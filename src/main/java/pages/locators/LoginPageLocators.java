package pages.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By LOGIN_FORM = By.id("login_form");
    public static final By REGISTER_FORM = By.id("register_form");
    public static final By EMAIL_FORM = By.id("id_registration-email");
    public static final By PASSWORD_FORM = By.id("id_registration-password1");
    public static final By PASSWORD_FORM_REPEAT = By.id("id_registration-password2");
    public static final By REGISTER_BUTTON = By.cssSelector("button[name='registration_submit']");
}
