package auto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AllFilter {
    private final SelenideElement filterDialogTitle = $x("//div[text()='Tất cả bộ lọc']");
    private final SelenideElement priceMin = $x("//input[@placeholder='Từ']");
    private final SelenideElement priceMax = $x("//input[@placeholder='Đến']");
    private final SelenideElement viewResultButton = $x("//div[text()='Xem kết quả']");
    private final SelenideElement filterPopup = $x("//div[contains(@class,'styles__StyledContentModal-sc')]");

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement setDynamicSupplier(String input) {
        String supplierCheckBox = "//div[text()='Nhà cung cấp']//following-sibling::div/button/div[text()='%s']";
        return $x(String.format(supplierCheckBox, input));
    }

    private String getScrollString(String popup, String element) {
        String scrollString = "document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollTop = " +
                "document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetTop;";
        return String.format(scrollString, popup, element);
    }

    public void verifyAllFilterDialogDisplay() {
        filterDialogTitle.shouldBe(Condition.visible);
    }

    public void chooseSupplier(String input) {

        setDynamicSupplier(input).setSelected(true);
    }


    public void enterMinPrice(int input) {
        Selenide.executeJavaScript(
                "document.evaluate(\"//div[contains(@class,'styles__StyledContentModal-sc')]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollTop = " +
                        "document.evaluate(\"//input[@placeholder='Từ']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetTop;"
        );
        priceMin.setValue(String.valueOf(input));
    }

    public void enterMaxPrice(int input) {
        Selenide.executeJavaScript(
                "document.evaluate(\"//div[contains(@class,'styles__StyledContentModal-sc')]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollTop = " +
                        "document.evaluate(\"//input[@placeholder='Đến']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetTop;"
        );
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
}
