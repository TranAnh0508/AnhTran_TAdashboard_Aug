package auto;

import auto.listeners.RetryAnalyzer;
import auto.model.Product;
import auto.page.SearchedPage;
import auto.page.SelectedProductPage;
import auto.page.TikiMainPage;
import auto.utils.Assertion;
import auto.utils.ListUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class TestCase01 extends TestBase{
    private final TikiMainPage tikiMainPage = new TikiMainPage();
    private final SearchedPage searchedPage = new SearchedPage();
    private final SelectedProductPage selectedProductPage = new SelectedProductPage();
    String searchText, comparedBreadcrumb;
    Integer searchIndex;
    Product productInList;

    @Test(description = "Verify the product information loaded correctly") //, retryAnalyzer = RetryAnalyzer.class
    public void TC_01() {
        searchText = "Điện thoại";
        comparedBreadcrumb = "Trang chủ > Kết quả tìm kiếm \"Điện thoại\"";

        tikiMainPage.verifySearchTbxDisplayed();
        tikiMainPage.verifySearchBtnDisplayed();

        tikiMainPage.searchProduct(searchText);

        System.out.println(searchedPage.getBreadcrumb());
        Assertion.assertTrue(searchedPage.getBreadcrumb().equals(comparedBreadcrumb),"Breadcrumb is correct");

        searchIndex = ListUtils.getRandomIndexInList(searchedPage.getProductList());

        productInList = searchedPage.getProductInfo(searchIndex);

        searchedPage.selectAProduct(searchIndex);
        selectedProductPage.waitForDiscount();

        Assertion.assertTrue(productInList.equals(selectedProductPage.getSelectedProductInfo()), "Selected Item is not displayed correctly");
    }
}
