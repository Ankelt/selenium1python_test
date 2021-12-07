import org.testng.annotations.Test;
import pages.BasePage;
import pages.BasketPage;
import pages.LoginPage;

import static constants.Constants.Urls.PYTHON_HOME_PAGE;

public class BasePageTest extends BaseTest {
    @Test (groups = {"login_guest"})
    public void TestGuestCanGoToLoginPage() {
        BasePage basePage = new BasePage(driver, PYTHON_HOME_PAGE);
        basePage.open();
        basePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver, driver.getCurrentUrl());
        loginPage.shouldBeLoginPage();

    }

    @Test (groups = {"login_guest"})
    public void TestGuestShouldSeeLoginLink() {
        BasePage basePage = new BasePage(driver, PYTHON_HOME_PAGE);
        basePage.open();
        basePage.shouldBeLoginLink();
    }

    @Test
    public void TestGuestCantSeeProductInBasketOpenedFromBasePage() {
        BasePage basePage = new BasePage(driver, PYTHON_HOME_PAGE);
        basePage.open();
        basePage.goToBasketPage();
        BasketPage basketPage = new BasketPage(driver, driver.getCurrentUrl());
        basketPage.shouldBeEmpty();
        basketPage.shouldBeMessageAboutEmptiness();
    }
}
