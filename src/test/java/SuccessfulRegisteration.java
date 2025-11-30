import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SuccessfulRegisteration {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void RegisterUser() {
        Home home = new Home(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();

        Signup signup = new Signup(driver);
        Assert.assertTrue(signup.isNewUserTextVisible());

        signup.enterNameAndEmail("Youssef", "youssef" + System.currentTimeMillis() + "@test.com");
        signup.clickSignup();

        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        accountInfo.fillAccountInfo("123456");
        accountInfo.fillAddressInfo();
        accountInfo.clickCreateAccount();

        AccountCreatedPage created = new AccountCreatedPage(driver);
        Assert.assertTrue(created.isAccountCreatedVisible());
        created.clickContinue();

        Login logged = new Login(driver);
        Assert.assertTrue(logged.isLoggedInVisible());
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}