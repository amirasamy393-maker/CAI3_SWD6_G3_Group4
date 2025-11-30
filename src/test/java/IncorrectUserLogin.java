import Pages.Home;
import Pages.Signup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class IncorrectUserLogin {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void incorrectUser() {
        Home home = new Home(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();

        Signup signup = new Signup(driver);
        Assert.assertTrue(signup.isLoginVisible());

        signup.enterUser("123@gmail.com", "123456");
        signup.clickLogin();

        Assert.assertTrue(signup.incorrectUserVisible());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
