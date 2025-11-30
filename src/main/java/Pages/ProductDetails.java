package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProductDetails extends BasePAGE {

    public ProductDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

@FindBy(id = "quantity")
WebElement quantityInput;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement viewCartButton;

    @FindBy(css = "div.product-information")
    WebElement productInfoSection;

    private By productName = By.xpath("//div[@class='product-information']//h2");
    private By productCategory = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    private By productPrice = By.xpath("//div[@class='product-information']//span//span");
    private By productAvailability = By.xpath("//div[@class='product-information']//p//b[contains(text(),'Availability')]");
    private By productCondition = By.xpath("//div[@class='product-information']//p//b[contains(text(),'Condition')]");
    private By productBrand = By.xpath("//div[@class='product-information']//p//b[contains(text(),'Brand')]");

    public boolean isProductDetailsVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productInfoSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

public void setQuantity(int qty) {
    quantityInput.clear();
    quantityInput.sendKeys(String.valueOf(qty));
    System.out.println("Quantity set to: " + qty);
}

public void clickAddToCart() {
    addToCartButton.click();
    System.out.println("Clicked 'Add to Cart'");
}
    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
    }

    public boolean isProductNameVisible() {
        return isElementVisible(productName);
    }

    public boolean isProductCategoryVisible() {
        return isElementVisible(productCategory);
    }

    public boolean isProductPriceVisible() {
        return isElementVisible(productPrice);
    }

    public boolean isProductAvailabilityVisible() {
        return isElementVisible(productAvailability);
    }

    public boolean isProductConditionVisible() {
        return isElementVisible(productCondition);
    }

    public boolean isProductBrandVisible() {
        return isElementVisible(productBrand);
    }
}

