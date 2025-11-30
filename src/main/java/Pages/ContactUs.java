package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends BasePAGE {

    public ContactUs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement getInTouchText;

    @FindBy(name = "name")
    WebElement nameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "subject")
    WebElement subjectInput;

    @FindBy(id = "message")
    WebElement messageInput;

    @FindBy(name = "upload_file")
    WebElement uploadFileInput;

    @FindBy(name = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//a[text()=' Home']")
    WebElement homeButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;

    public boolean isGetInTouchVisible() {
        return getInTouchText.isDisplayed();
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageInput.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        uploadFileInput.sendKeys(filePath);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickHome() {
        homeButton.click();
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
    public WebElement getGetInTouchText() {
        return getInTouchText;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }
}
