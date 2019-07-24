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

    public void hoverOverByElementFrom(By element, int index) {
        Actions builder = new Actions(driver);
        WebElement webElement = driver.findElements(element).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        builder.moveToElement(webElement).build().perform();
    }

    public void hoverOverByElement(By element) {
        Actions builder = new Actions(driver);
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        builder.moveToElement(webElement).build().perform();
    }

    public void hoverOverWebElement(WebElement webElement) {
        Actions builder = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        builder.moveToElement(webElement).build().perform();
    }
}
