package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Checkout extends BasePAGE {

    @FindBy(css = "a[href='/login'] u")
    WebElement registerLoginButton;

    @FindBy(css = "textarea[name='message']")
    WebElement commentTextArea;

    @FindBy(css = "a[href='/payment']")
    WebElement placeOrderButton;

    @FindBy(css = "#checkoutModal .modal-content")
    WebElement checkoutModal;

    @FindBy(css = "#checkoutModal button.close")
    WebElement closeModalButton;

    @FindBy(css = "h2[class='heading']")
    WebElement addressDetailsHeading;

    public Checkout(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterLogin() {
        closeModalIfPresent();
        clickWithJS(registerLoginButton);
    }

    public void enterComment(String comment) {
        commentTextArea.clear();
        commentTextArea.sendKeys(comment);
    }

    public void clickPlaceOrder() {
        clickWithJS(placeOrderButton);
    }

    public boolean verifyAddressDetails() {
        try {
            return addressDetailsHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void closeModalIfPresent() {
        try {
            if (checkoutModal.isDisplayed()) {
                clickWithJS(closeModalButton);
            }
        } catch (Exception e) {
        }
    }
}