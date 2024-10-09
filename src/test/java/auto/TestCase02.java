package auto;

import auto.model.Product;
import auto.page.RecentlyViewSection;
import auto.page.SearchedPage;
import auto.page.SelectedProductPage;
import auto.page.TikiMainPage;
import auto.utils.Assertion;
import auto.utils.ListUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class TestCase02 extends TestBase{
    private final TikiMainPage tikiMainPage = new TikiMainPage();
    private final SearchedPage searchedPage = new SearchedPage();
    private final SelectedProductPage selectedProductPage = new SelectedProductPage();
    private final RecentlyViewSection recentlyViewSection = new RecentlyViewSection();
    Product selectedProduct, recentlyProduct;
    String category;
    int searchIndex;

    @Test(description = "Verify viewed item displays in the \"Sản phẩm đã xem\" section")
    public void TC_02() {
        category = "Thể Thao - Dã Ngoại";

        tikiMainPage.clickOnCategory(category);

        searchedPage.waitForPageLoad();
        searchIndex = ListUtils.getRandomIndexInList(searchedPage.getProductList());
        searchedPage.selectAProduct(searchIndex);

        selectedProduct = selectedProductPage.getSelectedProductInfo();
        selectedProductPage.goToHomePage();

        tikiMainPage.clickOnCategory(category);
        Assertion.assertFalse(recentlyViewSection.checkProductExisted(selectedProduct, recentlyProduct), "Recently View Item is displayed");
    }
}
