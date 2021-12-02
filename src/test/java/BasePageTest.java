import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

import static constants.Constants.Urls.PYTHON_HOME_PAGE;

public class BasePageTest extends BaseTest {
    @Test
    public void TestGuestCanGoToLoginPage() {
        BasePage basePage = new BasePage(driver, PYTHON_HOME_PAGE);
        basePage.open();
        basePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver, driver.getCurrentUrl());
        loginPage.shouldBeLoginPage();

    }

}
