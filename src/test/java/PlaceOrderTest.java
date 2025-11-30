import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.*;
import java.time.Duration;

public class PlaceOrderTest {

    WebDriver driver;
    WebDriverWait wait;
    Home homePage;
    Products productsPage;
    Login login;
    Cart cartPage;
    Signup signupPage;
    AccountCreatedPage accountCreatedPage;
    Checkout checkoutPage;
    Payment paymentPage;
    AccountDeletedPage accountDeletedPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigateToHome() {
        driver.get("https://automationexercise.com");

        homePage = new Home(driver);
        productsPage = new Products(driver);
        login = new Login(driver);
        cartPage = new Cart(driver);
        signupPage = new Signup(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        checkoutPage = new Checkout(driver);
        paymentPage = new Payment(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
    }

    @Test
    public void testPlaceOrderRegisterWhileCheckout() {
        Assert.assertTrue(homePage.isHomePageVisible());

        homePage.clickProducts();
        productsPage.addBlueTopToCart();
        productsPage.clickContinueShopping();
        productsPage.addMenTshirtToCart();
        productsPage.clickViewCart();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        Assert.assertTrue(cartPage.isProceedToCheckoutVisible());

        cartPage.clickProceedToCheckout();
        checkoutPage.clickRegisterLogin();

        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        login.enterSignupName("Test User");
        login.enterSignupEmail(email);
        login.clickSignup();

        signupPage.fillDetails(
                "password123",
                "25",
                "June",
                "2005",
                "mrmr",
                "fawzy",
                "ABC Company",
                "123 St",
                "Apt 4",
                "Egypt",
                "Cairo",
                "Helwan",
                "17321",
                "1234567890"
        );

        signupPage.clickCreateAccount();
        Assert.assertTrue(accountCreatedPage.isAccountCreatedVisible());
        accountCreatedPage.clickContinue();

        Assert.assertTrue(homePage.getLoggedInAsText().contains("Logged in as"));

        homePage.clickCart();
        cartPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.verifyAddressDetails());

        checkoutPage.enterComment("Test order comment");
        checkoutPage.clickPlaceOrder();

        paymentPage.enterPaymentDetails("Test User", "4111111111111111", "123", "12", "2025");
        paymentPage.clickPayAndConfirm();

        String successMsg = paymentPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("Congratulations") || successMsg.contains("ORDER PLACED"));

        paymentPage.clickContinueAfterPayment();
        homePage.clickDeleteAccount();

        Assert.assertTrue(accountDeletedPage.isDeletedVisible());
        accountDeletedPage.clickContinue();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
