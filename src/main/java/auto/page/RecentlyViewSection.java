package auto.page;

import auto.model.Product;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RecentlyViewSection {
    private final SelenideElement noProductText = $x("//div[text() ='Không có sản phẩm nào']");

//    public Product getRecentlyViewProductInfo() {
//        return Product.builder()
//                .productName(selectedProductName.getText())
//                .productPrice(selectedProductPrice.getText())
//                .build();
//    }

    public boolean isNoProductTextDisplayed() {
        return noProductText.isDisplayed();
    }

    public boolean checkProductExisted(Product product1, Product product2) {
        try {
            if (isNoProductTextDisplayed()) {
                return false;
            }
        } catch (Exception ignored) {
        }
        return product1.equals(product2);
    }
}
