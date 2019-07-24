package Products;

import Pages.BasicNavigation;
import Pages.MainMenuLeft;
import Pages.ProductsDevelop.CompareProductsPage;
import Utilities.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareProductsTest extends BaseTestClass {

    MainMenuLeft mainMenuLeftObj;
    BasicNavigation basicNavigationObj;
    CompareProductsPage compareProductsPageObj;

    @BeforeMethod
    public void beforeTestMethod() {
        mainMenuLeftObj = new MainMenuLeft(driver);
        compareProductsPageObj = new CompareProductsPage(driver);
        basicNavigationObj = new BasicNavigation(driver)
                .popUpBannerClose();
    }

    @Test
    public void CompareProduct() {
        int countProductDifferences = mainMenuLeftObj
                .notebooksComputersLinkHover()
                .notebooksSubmenuLinkClick()
                .notebooksWithSSDLinkClick()
                .productItemAddToCompare(0)
                .productItemAddToCompare(1)
                .waitForCompareCounterWithValueIsVisible(5000, "2")
                .compareProductsButtonClick()
                .compareThisProductsButtonClick()
                .findDifferencesBetweenTwoProduct();

        int countedProductDifferences = compareProductsPageObj
                .onlyDifferencesLinkClick()
                .countOnlyDifferentProductCells();

        compareProductsPageObj
                .assertDifferencesCountedSuccessfully(countProductDifferences, countedProductDifferences);
    }


}
