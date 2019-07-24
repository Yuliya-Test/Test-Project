package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.log4j.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    protected WebDriver driver;
    private static final Logger log = Logger.getLogger(BaseTestClass.class);

    @BeforeTest
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();
        log.info("Driver instance is created");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        log.info("Enabled Chrome options");

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        log.info("Navigate to the site");

    }

    @AfterClass
    public void afterClass() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
