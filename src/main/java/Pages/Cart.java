package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Cart extends BasePAGE {

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_quantity_delete")
    WebElement deleteButton;

    @FindBy(css = "tr.cart_item td.product-name")
    List<WebElement> productsInCart;

    @FindBy(css = "a.btn.btn-default.check_out")
    WebElement proceedToCheckout;

    public boolean isCartPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/view_cart"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    public boolean isProductInCart(String productName) {
        for (WebElement product : productsInCart) {
            if (product.getText().trim().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        clickWithJS(proceedToCheckout);
    }
    public boolean isProceedToCheckoutVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOf(proceedToCheckout)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
