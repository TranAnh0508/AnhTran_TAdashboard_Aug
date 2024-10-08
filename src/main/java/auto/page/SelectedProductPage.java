package auto.page;

import auto.model.Product;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SelectedProductPage {
    private final SelenideElement selectedProductName = $x("//h1[contains(@class, 'Title__TitledStyled-sc')]");
    private final SelenideElement selectedProductPrice = $x("//div[@class = 'product-price__current-price']");

    public Product getSelectedProductInfo() {
        return Product.builder()
                .productName(selectedProductName.getText())
                .productPrice(selectedProductPrice.getText())
                .build();
    }

    //Wait for the Tiki discount the Price
    public void waitForDiscount() {
        Selenide.sleep(2000);
    }
}
