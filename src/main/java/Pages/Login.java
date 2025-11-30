package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends BasePAGE {

    @FindBy(css = "input[data-qa='signup-name']")
    WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signupButton;

    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedInVisible() {
        return driver.findElement(loggedInText).isDisplayed();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
    public void enterSignupName(String name) {
        wait.until(ExpectedConditions.visibilityOf(signupName)).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        signupEmail.sendKeys(email);
    }

    public void clickSignup() {
        signupButton.click();
    }
}


