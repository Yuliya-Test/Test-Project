package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasicNavigation {

    private WebDriver driver;

    public BasicNavigation(WebDriver driver) {
        this.driver = driver;
    }

    private By popUpBanner = By.cssSelector(".exponea-banner");
    private By popUpBannerCloseButton = By.cssSelector(".exponea-close");

    public BasicNavigation popUpBannerClose() {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        List<WebElement> bannerElements = driver.findElements(popUpBanner);
        if(bannerElements.size() != 0) {
            wait.until(ExpectedConditions.elementToBeClickable(popUpBannerCloseButton));
            bannerElements.get(0).findElement(popUpBannerCloseButton).click();
        }
        return this;
    }
}
