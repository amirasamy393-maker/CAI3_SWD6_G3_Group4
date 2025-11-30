package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Products extends BasePAGE {

    public Products(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.btn.btn-default.cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//p[text()='Blue Top']/following-sibling::a")
    WebElement blueTopAddToCart;

    @FindBy(xpath = "//p[text()='Men Tshirt']/following-sibling::a")
    WebElement menTshirtAddToCart;

    @FindBy(css = "a[href='/view_cart'] u")
    WebElement viewCartButton;

    @FindBy(css = "button.close-modal")
    WebElement continueShoppingButton;

    private By firstViewProduct = By.xpath("(//a[text()='View Product'])[1]");
    private By allProductsTitle = By.xpath("//h2[contains(text(),'All Products')]");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By productsList = By.xpath("//div[@class='features_items']");
    private By productItems = By.xpath("//div[@class='productinfo text-center']");

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickViewCart() {
        clickWithJS(viewCartButton);
    }

    public void clickContinueShopping() {
        clickWithJS(continueShoppingButton);
    }

    public boolean verifyAllProductsPage() {
        return isElementVisible(allProductsTitle);
    }

    public boolean isProductsListVisible() {
        return isElementVisible(productsList);
    }

    public void clickFirstViewProduct() {
        scrollDown();
        click(firstViewProduct);
    }

    public boolean verifySearchSection() {
        return isElementVisible(searchedProductsTitle);
    }

    public boolean areSearchProductsVisible() {
        List<WebElement> products = driver.findElements(productItems);
        return !products.isEmpty() && products.get(0).isDisplayed();
    }

    public void addBlueTopToCart() {
        try {
            Thread.sleep(1000);
            clickWithJS(blueTopAddToCart);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addMenTshirtToCart() {
        try {
            Thread.sleep(1000);
            clickWithJS(menTshirtAddToCart);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void scrollDown() {
        super.scrollDown();
    }
}