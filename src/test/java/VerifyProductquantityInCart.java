import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyProductquantityInCart {

    WebDriver driver;
    WebDriverWait wait;

    Home homePage;
    ProductDetails productDetails;
    Cart cartPage;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");

        homePage = new Home(driver);
        productDetails = new ProductDetails(driver);
        cartPage = new Cart(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void verifyHomePageVisible() {
        Assert.assertTrue(homePage.isHomePageVisible());
    }

    @Test(priority = 2)
    public void viewFirstProduct() {
        homePage.closeAdIfPresent();
        homePage.clickViewFirstProduct();
    }

    @Test(priority = 3)
    public void verifyProductDetailsOpened() {
        Assert.assertTrue(productDetails.isProductDetailsVisible());
    }

    @Test(priority = 4)
    public void setQuantityAndAddToCart() {
        productDetails.setQuantity(4);
        productDetails.clickAddToCart();
    }

    @Test(priority = 5)
    public void viewCart() {
        productDetails.clickViewCart();
    }

    @Test(priority = 6)
    public void verifyProductQuantityInCart() {
        int expectedQuantity = 4;

        WebElement quantityElement = null;

        try {
            quantityElement = driver.findElement(By.cssSelector(".cart_quantity"));
        } catch (Exception e) {
            try {
                quantityElement = driver.findElement(By.xpath("//td[@class='cart_quantity']/button"));
            } catch (Exception e2) {
                quantityElement = driver.findElement(By.xpath("//td[@class='cart_quantity']"));
            }
        }

        String quantityText = quantityElement.getText().trim();
        int actualQuantity = Integer.parseInt(quantityText);

        Assert.assertEquals(actualQuantity, expectedQuantity);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}