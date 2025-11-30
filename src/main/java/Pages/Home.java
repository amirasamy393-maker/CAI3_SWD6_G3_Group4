package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;

public class Home extends BasePAGE {

    public Home(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='logo pull-left']")
    WebElement homeLogo;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
    WebElement contactUsButton;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartButton;

    @FindBy(css = "a[href='/products']")
    WebElement productsButton;

    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccountButton;

    @FindBy(id = "search_product")
    WebElement searchInput;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(css = ".left-sidebar .panel-group")
    WebElement categoriesSidebar;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInAs;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

    By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");

    public boolean isHomePageVisible() {
        return homeLogo.isDisplayed();
    }

    public void clickAddFirstProduct() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollBy(0, 500)");

            WebElement addButton = driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]"));

            js.executeScript("arguments[0].scrollIntoView(true);", addButton);
            js.executeScript("arguments[0].click();", addButton);

        } catch (Exception e) {
        }
    }

    public void clickContinueShopping() {
        try {
            wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
            continueShoppingButton.click();
        } catch (Exception e) {
        }
    }

    public void clickCartButton() {
        scrollDown();
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    public void clickContactUs() {
        contactUsButton.click();
    }

    public void clickViewFirstProduct() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollBy(0, 500)");

            WebElement viewButton = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));

            js.executeScript("arguments[0].scrollIntoView(true);", viewButton);
            js.executeScript("arguments[0].click();", viewButton);

        } catch (Exception e) {
        }
    }

    public void clickWomenCategory() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement womenCategory = driver.findElement(By.xpath("//a[text()='Women']"));

            js.executeScript("arguments[0].scrollIntoView(true);", womenCategory);
            js.executeScript("arguments[0].click();", womenCategory);

        } catch (Exception e) {
        }
    }

    public void clickWomenTopsSubCategory() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement topsSubCategory = driver.findElement(By.xpath("//a[text()='Tops']"));

            js.executeScript("arguments[0].scrollIntoView(true);", topsSubCategory);
            js.executeScript("arguments[0].click();", topsSubCategory);

        } catch (Exception e) {
        }
    }

    public void clickSubCategoryUnderMen(String subCategoryName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement subCategory = driver.findElement(By.xpath(
                    "//div[@class='panel-group']//a[text()='Men']/following::ul[1]//a[text()='" + subCategoryName + "']"
            ));

            js.executeScript("arguments[0].scrollIntoView(true);", subCategory);
            js.executeScript("arguments[0].click();", subCategory);

        } catch (Exception e) {
        }
    }

    public boolean areCategoriesVisible() {
        return categoriesSidebar.isDisplayed();
    }

    public boolean isCategoryPageDisplayed(String expectedText) {
        try {
            WebElement categoryHeader = driver.findElement(By.xpath("//h2[contains(text(),'" + expectedText + "')]"));
            return categoryHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    public void clickProducts() {
        productsButton.click();
    }

    public void clickCart() {
        cartButton.click();
    }

    public String getLoggedInAsText() {
        return loggedInAs.getText();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }

    public void clickContinue() {
        try {
            continueButton.click();
        } catch (Exception e) {
        }
    }

    public void goToProductsPage() {
        clickProducts();
    }

    public void searchForProduct(String productName) {
        searchInput.sendKeys(productName);
        searchButton.click();
    }
}