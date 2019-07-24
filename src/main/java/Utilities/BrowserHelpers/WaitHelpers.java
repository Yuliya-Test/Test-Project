package Utilities.BrowserHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelpers {

    private WebDriver driver;

    public WaitHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForJSandJQueryToLoad(int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public boolean waitForElementContainsText(final String text, final By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.until(new ExpectedCondition<Boolean>() {
                       public Boolean apply(WebDriver driver) {
                           return driver.findElement(element).getText().contains(text);
                       }
                   }
        );
        return false;
    }

    public void threadSleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
