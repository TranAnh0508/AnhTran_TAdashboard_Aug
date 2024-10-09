package auto.page;

import auto.model.Product;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SearchedPage {
    private final SelenideElement headerLogo = $x("//a[@data-view-id='header_main_logo']");
    private final SelenideElement breadcrumb = $x("//div[@class='breadcrumb']");
    private final ElementsCollection productList = $$x("//div[contains(@class,'CatalogProducts__Wrapper')]//a");
    private final ElementsCollection productName = $$x("//h3[contains(@class,'style__NameStyled')]");
    private final ElementsCollection productPrice = $$x("//div[@class = 'price-discount__price']");
    private final SelenideElement allFilterBtn = $x("//div[text()='Tất cả']");
    private final ElementsCollection recentlyViewProduct = $$x("//div[@data-view-id='product_list_recently_view_container']");

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement setDynamicDetailedCategory(String input) {
        String detailedCategory = "//div[contains(@class,'styles__SubItemContainer-sc')]//div//a[text()='%s']";
        return $x(String.format(detailedCategory, input));
    }

    public String getBreadcrumb() {
        return breadcrumb.getText().replace("\n", " > ");
    }

    public ElementsCollection getProductList() {
        return productList;
    }

    public Product getProductInfo(Integer index) {
        return Product.builder()
                .productName(productName.get(index).getText())
                .productPrice(productPrice.get(index).getText())
                .build();
    }

    public void selectAProduct(Integer index) {
        productList.get(index).click();
    }

    @Step("Select the detailed category")
    public void clickOnDetailedCategory(String input) {
        setDynamicDetailedCategory(input).click();
    }

    //Wait for the Page load
    public void waitForPageLoad() {
        Selenide.sleep(2000);
    }

    @Step("Click all filter")
    public void clickAllFilterBtn() {
        allFilterBtn.click();
    }

    @Step("Go back to Home page")
    public void goToHomePage() {
        headerLogo.click();
    }

    public boolean verifyAllProductNames(String input) {
        for (SelenideElement nameElement : productName) {
            String name = nameElement.getText();
            if (!name.contains(input)) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllProductPricesInRange(int min, int max) {
        for (SelenideElement priceElement : productPrice) {
            String priceText = priceElement.getText().replace(".", "").trim();
            String priceText2 = priceText.replace("₫", "").trim();
            int price = Integer.parseInt(priceText2);
            if (price > min && price < max) {
                return true;
            }
        }
        return false;
    }
}
