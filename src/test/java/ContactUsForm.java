import Pages.ContactUs;
import Pages.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class ContactUsForm {

    WebDriver driver;
    WebDriverWait wait;
    Home homePage;
    ContactUs contactUsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigateToHome() {
        driver.get("http://automationexercise.com");
        homePage = new Home(driver);
        contactUsPage = new ContactUs(driver);
    }

    @Test
    public void contactUsFormTest() {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home Page is not visible");

        homePage.clickContactUs();

        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getGetInTouchText()));
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "Get in Touch text not visible");

        contactUsPage.enterName("Nervana QA");
        contactUsPage.enterEmail("test" + System.currentTimeMillis() + "@gmail.com");
        contactUsPage.enterSubject("Testing Contact Form");
        contactUsPage.enterMessage("This is a Test Message from Automation script");

        contactUsPage.clickSubmit();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }

        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getSuccessMessage()));
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(),
                "Success message is not displayed");

        contactUsPage.clickHome();
        Assert.assertTrue(homePage.isHomePageVisible(), "Did not return to Home page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}