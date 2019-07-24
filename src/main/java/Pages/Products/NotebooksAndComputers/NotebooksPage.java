package Pages.Products.NotebooksAndComputers;

import Pages.ProductsDevelop.CompareProductsPage;
import Utilities.BrowserHelpers.ActionsHelpers;
import Utilities.BrowserHelpers.WaitHelpers;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotebooksPage {

    private WebDriver driver;
    private static final Logger log = Logger.getLogger(NotebooksPage.class);

    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
    }

    private By notebooksWithSSDLink = By.cssSelector(".pab-img a[onclick*='Ноутбуки с SSD']");
    private By productItems = By.cssSelector("[data-view_type='catalog_with_hover']");
    private By productsCompareIcon = By.cssSelector(".g-compare-icon");
    private By selectedProductsCompareIcon = By.cssSelector(".incomparison .g-compare-icon");
    private By compareIcon = By.id("comparison");
    private By compareCounter = By.cssSelector(".hub-i-count");
    private By comparePopup = By.cssSelector("#comparison-popup:not(.hidden)");

    public  NotebooksPage notebooksWithSSDLinkClick() {
        driver.findElement(notebooksWithSSDLink).click();
        log.info("Click 'Notebooks with SSD' link");
        return this;
    }

    public NotebooksPage productItemHover(int index) {
        new ActionsHelpers(driver).hoverOverByElementFrom(productItems, index);
        log.info("Hover over product item");
        return this;
    }

    public NotebooksPage productItemAddToCompare(int index) {
        productItemHover(index);
        waitForElementCompareIconIsVisible(index);
        driver.findElements(productsCompareIcon).get(index).click();
        waitForElementSelectedProductCompareIconIsVisible();
        log.info("Add product to compare");
        return this;
    }

    public CompareProductsPage compareProductsButtonClick() {
        driver.findElement(compareIcon).click();
        log.info("Compare Products button click");
        return new CompareProductsPage(driver);
    }

    //Wait
    public NotebooksPage waitForElementCompareIconIsVisible (int index) {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElements(productsCompareIcon).get(index)));
        return this;
    }

    public NotebooksPage waitForCompareCounterWithValueIsVisible(int timeout, String text) {
        new WaitHelpers(driver).waitForElementContainsText(text, compareCounter, 5000);
        return this;
    }

    public NotebooksPage waitForElementSelectedProductCompareIconIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectedProductsCompareIcon)));
        return this;
    }

}
