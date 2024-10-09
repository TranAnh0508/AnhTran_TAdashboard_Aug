package auto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AllFilter {
    private final SelenideElement filterDialogTitle = $x("//div[text()='Tất cả bộ lọc']");
    private final String supplierCheckBox = "//span[text()='%s']/parent::div//preceding-sibling::div"; ///span[@class='box']
    private final SelenideElement priceMin = $x("//input[@placeholder='Từ']");
    private final SelenideElement priceMax = $x("//input[@placeholder='Đến']");
    private final SelenideElement viewResultButton = $x("//div[text()='Xem kết quả']");
    private final String filterPopup = "//div[contains(@class,'styles__StyledContentModal-sc')]";

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement setDynamicSupplier(String input) {
        return $x(String.format(supplierCheckBox, input));
    }

    private SelenideElement setFilterPopup() {
        return $x(filterPopup);
    }

    //Lấy chuỗi xpath của Supplier
    private String setSupplierXpathString(String input) {
        return String.format(supplierCheckBox, input);
    }

    private String getScrollString(String element) {
        String scrollString = "document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollTop = " +
                "document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetTop;";
        return String.format(scrollString, "//div[contains(@class,'styles__StyledContentModal-sc')]", element);
    }

    public void chooseSupplier(String input) {
        setDynamicSupplier(input).scrollTo();
        setDynamicSupplier(input).setSelected(true);
    }

    public void enterMinPrice(int input) {
        priceMin.scrollTo();
        priceMin.setValue(String.valueOf(input));
    }

    public void enterMaxPrice(int input) {
        priceMax.scrollTo();
        priceMax.setValue(String.valueOf(input));
    }

    @Step("Enter Min and Max prices")
    public void enterPriceRange(int min, int max) {
        enterMinPrice(min);
        enterMaxPrice(max);
    }

    @Step("Click on Xem kết quả")
    public void clickOnViewResult() {
        viewResultButton.click();
    }

    public void verifyAllFilterDialogDisplay() {
        filterDialogTitle.shouldBe(Condition.visible);
    }
}
