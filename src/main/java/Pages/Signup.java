package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Signup extends BasePAGE {
    public Signup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'New User Signup')]")
    WebElement newUserText;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    WebElement loginText;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement incorrectUser;

    @FindBy(xpath = "//p[contains(text(),'Email Address already exist')]")
    WebElement existingUser;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createAccountButton;

    @FindBy(id = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement newsletter;

    @FindBy(id = "optin")
    WebElement optin;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;

    public boolean isNewUserTextVisible() {
        return newUserText.isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        nameField.clear();
        nameField.sendKeys(name);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSignup() {
        signupButton.click();
    }

    public boolean isLoginVisible() {
        return loginText.isDisplayed();
    }

    public void enterUser(String email, String Password){
        loginEmail.clear();
        loginEmail.sendKeys(email);
        loginPassword.clear();
        loginPassword.sendKeys(Password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean incorrectUserVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement incorrectMsg = wait.until(ExpectedConditions.visibilityOf(incorrectUser));
        return incorrectMsg != null && incorrectMsg.isDisplayed();
    }

    public boolean ExistUserVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement existMsg = wait.until(ExpectedConditions.visibilityOf(existingUser));
            return existMsg != null && existMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillDetails(String pass, String day, String month, String year,
                            String fname, String lname, String comp, String addr1,
                            String addr2, String cntry, String st, String cty,
                            String zip, String mobile) {
        scrollDown();
        titleMr.click();
        password.sendKeys(pass);
        days.sendKeys(day);
        months.sendKeys(month);
        years.sendKeys(year);

        scrollDown();
        newsletter.click();
        optin.click();

        scrollDown();
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        company.sendKeys(comp);
        address1.sendKeys(addr1);
        address2.sendKeys(addr2);
        country.sendKeys(cntry);
        state.sendKeys(st);
        city.sendKeys(cty);
        zipcode.sendKeys(zip);
        mobileNumber.sendKeys(mobile);
    }

    public void clickCreateAccount() {
        scrollDown();
        createAccountButton.click();
    }
}