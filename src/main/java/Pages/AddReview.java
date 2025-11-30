package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReview extends BasePAGE {
    private By nameInput = By.id("name");
    private By emailInput = By.id("email");
    private By reviewTextArea = By.id("review");
    private By submitButton = By.id("button-review");
    private By successMsg = By.xpath("//div[contains(@class,'alert-success')]");
    private By reviewTitle = By.xpath("//a[contains(text(),'Write Your Review')]");

    public AddReview(WebDriver driver) {
        super(driver);
    }

    public boolean isReviewSectionVisible() {
        return isElementVisible(reviewTitle);
    }

    public void addReview(String name, String email, String review) {
        writeText(nameInput, name);
        writeText(emailInput, email);
        writeText(reviewTextArea, review);
        clickWithJS(findElement(submitButton));
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementVisible(successMsg);
    }

    public String getSuccessMessageText() {
        return getText(successMsg);
    }

    private WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}