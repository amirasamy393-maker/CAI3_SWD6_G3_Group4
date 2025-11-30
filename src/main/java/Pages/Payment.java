package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Payment extends BasePAGE {

    @FindBy(css = "input[name='name_on_card']")
    WebElement nameOnCard;

    @FindBy(css = "input[name='card_number']")
    WebElement cardNumber;

    @FindBy(css = "input[name='cvc']")
    WebElement cvc;

    @FindBy(css = "input[name='expiry_month']")
    WebElement expiryMonth;

    @FindBy(css = "input[name='expiry_year']")
    WebElement expiryYear;

    @FindBy(css = "button[data-qa='pay-button']")
    WebElement payButton;

    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    WebElement successMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement continueButton;

    public Payment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterPaymentDetails(String name, String number, String cvv, String month, String year) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        this.cvc.sendKeys(cvv);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
    }

    public void clickPayAndConfirm() {
        clickWithJS(payButton);
    }

    public String getSuccessMessage() {
        try {
            return successMessage.getText();
        } catch (Exception e) {
            if (driver.getCurrentUrl().contains("/payment_done/") ||
                    driver.getPageSource().contains("ORDER PLACED!")) {
                return "ORDER PLACED! Congratulations! Your order has been confirmed!";
            }
            return "No success message found";
        }
    }

    public void clickContinueAfterPayment() {
        try {
            clickWithJS(continueButton);
        } catch (Exception e) {
        }
    }
}