package auto;

import auto.page.AllFilter;
import auto.page.SearchedPage;
import auto.page.TikiMainPage;
import auto.utils.Assertion;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class TestCase01 extends TestBase{
    private final TikiMainPage tikiMainPage = new TikiMainPage();
    private final SearchedPage searchedPage = new SearchedPage();
    private final AllFilter allFilter = new AllFilter();
    String category, supplier, comparedBreadcrumb;
    int minPrice, maxPrice;

    @Test(description = "Verify user can filter search condition for product")
    public void TC_01() {
        category = "Nhà Sách Tiki";
        supplier = "Nhà sách Fahasa";
        comparedBreadcrumb = "Trang chủ > Nhà Sách Tiki";
        minPrice = 60000;
        maxPrice = 140000;

        tikiMainPage.clickOnCategory(category);

        searchedPage.waitForPageLoad();
        Assertion.assertTrue(searchedPage.getBreadcrumb().equals(comparedBreadcrumb),"Breadcrumb is not correct");

        searchedPage.clickAllFilterBtn();
        allFilter.verifyAllFilterDialogDisplay();

//        Chưa scroll xuống được
//        allFilter.chooseSupplier(supplier);
        allFilter.enterPriceRange(minPrice, maxPrice);
        allFilter.clickOnViewResult();

        //
        searchedPage.waitForPageLoad();
        Assertion.assertTrue(searchedPage.areAllProductPricesInRange(minPrice, maxPrice), "The price is not in range");
    }
}
