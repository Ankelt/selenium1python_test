import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BasketPage;
import pages.LoginPage;
import pages.ProductPage;

import java.util.Random;

import static constants.Constants.Urls.*;

public class ProductPageTest extends BaseTest{

    //need parametrization (maybe here data provider)
    @BeforeGroups (groups = {"AuthorisedUsers"})
    public void registration() {
        Random rand = new Random();
        String email = rand + "@fakemail.org";
        String password = "qwerty12345@!WOW";
        LoginPage loginPage = new LoginPage(driver, PYTHON_LOGIN_PAGE);
        loginPage.open();
        loginPage.registerNewUser(email, password);
        loginPage.shouldBeAuthorised();
    }

    @Test (groups = {"AuthorisedUsers"})
    public void testUserCantSeeSuccessMessage() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.shouldNotBeSuccessMessage();
    }

    @Test (groups = {"AuthorisedUsers"})
    public void testUserCanAddProductToBasket() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.shouldNotBeSuccessMessage();
        productPage.addProductToBasket();
        productPage.shouldBeCorrectAdding();
        productPage.shouldBeSuccessMessage();
    }

    @AfterGroups(groups = {"AuthorisedUsers"})
    public void Logout() {
        BasePage basePage = new BasePage(driver, PYTHON_HOME_PAGE);
        basePage.logout();
    }

    @AfterMethod(alwaysRun = true, onlyForGroups = "AddingToBasket")
    public void emptyBasketFromProductPage() {
        BasketPage basketPage = new BasketPage(driver, PYTHON_BASKET_PAGE);
        basketPage.open();
        basketPage.empty();
    }

    @Test (groups = {"AddingToBasket"})
    public void testGuestCanAddProductToBasket() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.shouldNotBeSuccessMessage();
        productPage.addProductToBasket();
        productPage.shouldBeCorrectAdding();
        productPage.shouldBeSuccessMessage();
    }

    @Test
    public void testGuestCantSeeSuccessMessage() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.shouldNotBeSuccessMessage();
    }

    @Test
    public void testGuestShouldSeeLoginLinkOnProductPage() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.shouldBeLoginLink();
    }

    @Test
    public void testGuestCanGoToLoginPageFromProductPage() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.goToLoginPage();
    }

    @Test
    public void testGuestCantSeeProductInBasketOpenedFromProductPage() {
        ProductPage productPage = new ProductPage(driver, PYTHON_PRODUCT_PAGE);
        productPage.open();
        productPage.goToBasketPage();
        BasketPage basketPage = new BasketPage(driver, driver.getCurrentUrl());
        basketPage.shouldBeEmpty();
        basketPage.shouldBeMessageAboutEmptiness();
    }
}
