
import Pages.Home;
import Pages.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProduct {
    private WebDriver driver;
    private Home home;
    private Products products;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        home = new Home(driver);
        products = new Products(driver);
    }

    @Test
    public void searchProductTest() {
        home.goToProductsPage();
        products.verifyAllProductsPage();
        home.searchForProduct("shirt");
        products.verifySearchSection();
        products.areSearchProductsVisible();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}