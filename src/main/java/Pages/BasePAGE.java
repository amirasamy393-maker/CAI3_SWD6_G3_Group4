package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class BasePAGE {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePAGE(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeAdIfPresent() {
        try {
            WebDriverWait adWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeAdButton = adWait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@id='dismiss-button']")
                    )
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeAdButton);
        } catch (Exception e) {}
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickWithJS(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {}
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }

    public void writeText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public void waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}