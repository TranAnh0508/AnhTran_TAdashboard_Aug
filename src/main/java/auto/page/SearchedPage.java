package auto.page;

import auto.model.Product;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SearchedPage {
    private final SelenideElement breadcrumb = $x("//div[@class='breadcrumb']");
    private final ElementsCollection productList = $$x("//div[contains(@class,'CatalogProducts__Wrapper')]//a");
    private final ElementsCollection productName = $$x("//h3[contains(@class,'style__NameStyled')]");
    private final ElementsCollection productPrice = $$x("//div[@class = 'price-discount__price']");

    private final SelenideElement allFilterBtn = $x("//div[text()='Tất cả']");

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
            String priceText = priceElement.getText().replace(",", "").trim();  // Lấy giá, loại bỏ dấu phẩy và khoảng trắng
            int price;
            try {
                price = Integer.parseInt(priceText);  // Chuyển đổi giá sang số nguyên
            } catch (NumberFormatException e) {
                // Nếu không thể chuyển giá thành số, trả về false ngay lập tức
                return false;
            }
            if (price < min || price > max) {  // Kiểm tra nếu giá không nằm trong khoảng 1000-1700
                return false;  // Nếu bất kỳ giá nào không nằm trong khoảng, trả về false
            }
        }
        return true;  // Trả về true nếu tất cả giá đều nằm trong khoảng
    }
}
