package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage extends BasePAGE {
    public AccountInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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
    WebElement offers;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "company")
    WebElement company;

    @FindBy(name = "address1")
    WebElement address1;

    @FindBy(name = "address2")
    WebElement address2;

    @FindBy(name = "country")
    WebElement country;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "zipcode")
    WebElement zipcode;

    @FindBy(name = "mobile_number")
    WebElement mobile;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createAccountBtn;

    public void fillAccountInfo(String pass) {
        scrollDown();
        titleMr.click();
        password.sendKeys(pass);

        new Select(days).selectByValue("10");
        new Select(months).selectByValue("5");
        new Select(years).selectByValue("1998");

        scrollDown();
        newsletter.click();
        offers.click();
    }

    public void fillAddressInfo() {
        scrollDown();
        firstName.sendKeys("Youssef");
        lastName.sendKeys("Khaled");
        company.sendKeys("ABC");
        address1.sendKeys("Street 1");
        address2.sendKeys("Street 2");
        new Select(country).selectByVisibleText("Canada");
        state.sendKeys("Cairo");
        city.sendKeys("Cairo");
        zipcode.sendKeys("00000");
        mobile.sendKeys("010000000");
    }

    public void clickCreateAccount() {
        scrollDown();
        createAccountBtn.click();
    }
}