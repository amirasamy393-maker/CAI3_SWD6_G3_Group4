import Pages.Home;
import Pages.Signup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExistingSignup {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void ExistingUser() {
        Home home = new Home(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();

        Signup signup = new Signup(driver);
        Assert.assertTrue(signup.isNewUserTextVisible());

        signup.enterNameAndEmail("Youssef", "Youssef123@gmail.com");
        signup.clickSignup();

        Assert.assertTrue(signup.ExistUserVisible()); // تصليح: استخدام signup.ExistUserVisible() بدل Signup.ExistUserVisible()
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}