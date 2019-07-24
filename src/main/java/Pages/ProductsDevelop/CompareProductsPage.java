package Pages.ProductsDevelop;

import Pages.Products.NotebooksAndComputers.NotebooksPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CompareProductsPage {

    private WebDriver driver;
    private static final Logger log = Logger.getLogger(NotebooksPage.class);

    public CompareProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By notebooksWithSSDLink = By.cssSelector(".pab-img a[onclick*='Ноутбуки с SSD']");
    private By compareThisProductsButton = By.cssSelector(".btn-link-to-compare a");
    private By compareProductRows = By.cssSelector(".comparison-t-row");
    private By compareProductCells = By.cssSelector(".comparison-t-cell");
    private By onlyDifferencesLink = By.cssSelector("[href='#only-different']");
    private By onlyDifferentProductCells = By.cssSelector(".comparison-t-row:not(.hidden)");

    public CompareProductsPage notebooksWithSSDLinkClick() {
        driver.findElement(notebooksWithSSDLink).click();
        return this;
    }

    public CompareProductsPage compareThisProductsButtonClick() {
        driver.findElement(compareThisProductsButton).click();
        log.info("Hover over product item");
        return this;
    }

    public int findDifferencesBetweenTwoProduct() {
        int diff = 0;
        for(WebElement compareProductRow : driver.findElements(compareProductRows)) {
            if(!compareProductRow.findElements(compareProductCells).get(0).getText().equals(
                    compareProductRow.findElements(compareProductCells).get(1).getText()))
                diff++;
        }
        System.out.println("Found differences: " + diff);
        log.info("Find differences between two  products: " + diff);
        return diff;
    }

    public CompareProductsPage onlyDifferencesLinkClick() {
        driver.findElement(onlyDifferencesLink).click();
        log.info("Only differences link click");
        return this;
    }

    public int countOnlyDifferentProductCells() {
        return driver.findElements(onlyDifferentProductCells).size();
    }

    //Asserts
    public CompareProductsPage assertDifferencesCountedSuccessfully(int countedValue, int existValue) {
        Assert.assertEquals(countedValue, existValue, "Counting false");
        log.info("Assert that differences between products counted Successfully");
        return this;
    }
}
