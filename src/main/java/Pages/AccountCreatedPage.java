package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BasePAGE {

    By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}