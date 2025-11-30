package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BasePAGE {
    public AccountDeletedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    By deletedText = By.xpath("//b[text()='Account Deleted!']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public boolean isDeletedVisible() {
        return driver.findElement(deletedText).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}