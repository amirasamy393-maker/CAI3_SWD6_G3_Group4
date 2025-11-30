
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyAllProducts {
    private WebDriver driver;
    private Home home;
    private Products products;
    private ProductDetails details;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        home = new Home(driver);
        products = new Products(driver);
        details = new ProductDetails(driver);
    }

    @Test
    public void verifyAllProductsAndDetails() {
        home.goToProductsPage();
        products.verifyAllProductsPage();
        products.isProductsListVisible();
        products.clickFirstViewProduct();
        details.isProductNameVisible();
        details.isProductCategoryVisible();
        details.isProductPriceVisible();
        details.isProductAvailabilityVisible();
        details.isProductConditionVisible();
        details.isProductBrandVisible();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}