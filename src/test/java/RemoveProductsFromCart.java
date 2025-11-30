import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class RemoveProductsFromCart {

    WebDriver driver;
    WebDriverWait wait;

    Home homePage;
    Cart cart;

    @BeforeClass
    public void setup() {
        System.out.println("STEP 1: Launch browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");

        homePage = new Home(driver);
        cart = new Cart(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void verifyHomePageVisible() {
        System.out.println("STEP 3: Verify Home Page is visible successfully");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Exercise");
    }

    @Test(priority = 2, description = "Add products to cart")
    public void addProductsToCart() {
        System.out.println("STEP 4: Add products to cart");
        homePage.clickAddFirstProduct();
        homePage.clickContinueShopping();
    }

    @Test(priority = 3, description = "Click 'Cart' button")
    public void clickCartButton() {
        System.out.println("STEP 5: Click 'Cart' button");
        homePage.scrollDown();
        homePage.clickCartButton();
    }

    @Test(priority = 4, description = "Verify that cart page is displayed")
    public void verifyCartPageDisplayed() {
        System.out.println("STEP 6: Verify that cart page is displayed");
        Assert.assertTrue(cart.isCartPageDisplayed());
    }

    @Test(priority = 5, description = "Click 'X' button corresponding to particular product")
    public void removeProductFromCart() {
        System.out.println("STEP 7: Click 'X' button corresponding to particular product");
        homePage.scrollDown();
        cart.removeProduct();
    }

    @Test(priority = 6, description = "Verify that product is removed from the cart")
    public void verifyProductRemoved() {
        System.out.println("STEP 8: Verify that product is removed from the cart");
        Assert.assertFalse(cart.isProductInCart("Blue Top"));
    }

    @AfterClass
    public void teardown() {
        System.out.println("Closing browser");
        driver.quit();
    }
}