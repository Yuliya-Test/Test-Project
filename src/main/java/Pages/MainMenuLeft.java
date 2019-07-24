package Pages;

import Pages.Products.NotebooksAndComputers.NotebooksPage;
import Utilities.BrowserHelpers.ActionsHelpers;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuLeft {

    private WebDriver driver;
    private static final Logger log = Logger.getLogger(MainMenuLeft.class);

    public MainMenuLeft(WebDriver driver) {
        this.driver = driver;
    }

    private By classicMenuBlock = By.cssSelector(".menu-wrapper_state_static");
    private By notebooksComputersLink = By.cssSelector(".menu-categories__link[href*='computers-notebook']");
    private By subMenuActive = By.cssSelector(".menu-wrapper.display-block .menu-categories__link_state_hovered+.menu__hidden-content .menu__main-cats-inner");
    private By notebooksSubmenuLink = By.cssSelector(".menu__hidden-title[href*='notebooks']");

    public MainMenuLeft notebooksComputersLinkHover() {
        new ActionsHelpers(driver).scrollToTopAndHoverOverWebElement(
                driver.findElement(classicMenuBlock).findElement(notebooksComputersLink)
        );

        waitForElementSubMenuIsVisible();
        log.info("Hover over 'Notebooks & Computers' option");
        return this;
    }

    public  NotebooksPage notebooksSubmenuLinkClick() {
        driver.findElement(subMenuActive).findElement(notebooksSubmenuLink).click();
        log.info("Click 'Notebooks' link");
        return new NotebooksPage(driver);
    }

    //Wait
    public MainMenuLeft waitForElementClassicMenuBlockIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(classicMenuBlock)));
        return this;
    }

    public MainMenuLeft waitForElementSubMenuIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(subMenuActive)));
        return this;
    }
}
