

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddReviewTest {
    private WebDriver driver;
    private Home home;
    private Products products;
    private AddReview review;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        home = new Home(driver);
        products = new Products(driver);
        review = new AddReview(driver);
    }

    @Test
    public void addReviewTest() {
        home.goToProductsPage();
        products.verifyAllProductsPage();
        products.clickFirstViewProduct();
        review.isReviewSectionVisible();
        review.addReview("Hadeer", "hadeer@gmail.com", "product is good");
        review.isSuccessMessageDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}