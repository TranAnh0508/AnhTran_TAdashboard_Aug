package auto;

import auto.page.AllFilter;
import auto.page.SearchedPage;
import auto.page.SelectedProductPage;
import auto.page.TikiMainPage;
import auto.utils.Assertion;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase{
    private final TikiMainPage tikiMainPage = new TikiMainPage();
    private final SearchedPage searchedPage = new SearchedPage();
    private final AllFilter allFilter = new AllFilter();
    private final SelectedProductPage selectedProductPage = new SelectedProductPage();
    String category, kitchen, comparedBreadcrumb;
    int minPrice, maxPrice;

    @Test(description = "Verify user can filter search condition for product")
    public void TC_02() {
        category = "Điện Gia Dụng";
        kitchen = "Lò vi sóng";
        comparedBreadcrumb = "Trang chủ > Điện Gia Dụng > Đồ dùng nhà bếp > Lò vi sóng";
        minPrice = 100;
        maxPrice = 200;

        tikiMainPage.clickOnCategory(category);
        searchedPage.clickOnDetailedCategory(kitchen);

        searchedPage.waitForPageLoad();
        Assertion.assertTrue(searchedPage.getBreadcrumb().equals(comparedBreadcrumb),"Breadcrumb is not correct");

        searchedPage.clickAllFilterBtn();
        allFilter.verifyAllFilterDialogDisplay();

        allFilter.enterPriceRange(minPrice, maxPrice);
    }
}
