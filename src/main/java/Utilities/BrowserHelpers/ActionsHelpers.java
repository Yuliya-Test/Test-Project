package Utilities.BrowserHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelpers {

    private WebDriver driver;

    public ActionsHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTopAndHoverOverByElementFrom(By element, int index) {
        Actions builder = new Actions(driver);
        WebElement webElement = driver.findElements(element).get(index);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0);", webElement);
        builder.moveToElement(webElement).perform();
    }

    public void scrollToTopAndHoverOverByElement(By element) {
        Actions builder = new Actions(driver);
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0);", webElement);
        builder.moveToElement(webElement).perform();
    }

    public void scrollToTopAndHoverOverWebElement(WebElement webElement) {
        Actions builder = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0);", webElement);
        builder.moveToElement(webElement).perform();
    }
}
