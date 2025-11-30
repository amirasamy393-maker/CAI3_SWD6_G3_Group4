import Pages.AccountDeletedPage;
import Pages.Home;
import Pages.Login;
import Pages.Signup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SuccessfulLogin {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void LoginUser() {
        Home home = new Home(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();

        Signup signup = new Signup(driver);
        Assert.assertTrue(signup.isLoginVisible());

        signup.enterUser("Youssef123@gmail.com", "123456");
        signup.clickLogin();

        Login logged = new Login(driver);
        Assert.assertTrue(logged.isLoggedInVisible());

        logged.clickLogout();

        Assert.assertTrue(signup.isLoginVisible());
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
