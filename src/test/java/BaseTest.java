import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.BasePage;


import static common.CommonActions.createDriver;
import static common.Config.CLEAR_COOKIES_AND_LOCAL_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

    public class BaseTest {
        protected WebDriver driver = createDriver();

        @AfterTest
        public void clearCookiesAndLocalStorage() {
            if (CLEAR_COOKIES_AND_LOCAL_STORAGE) {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                driver.manage().deleteAllCookies();
                javascriptExecutor.executeScript("window.sessionStorage.clear()");
            }
        }

        @AfterSuite (alwaysRun = true)
        public void clear() {
            if (HOLD_BROWSER_OPEN) {
                driver.quit();
            }
        }
    }
