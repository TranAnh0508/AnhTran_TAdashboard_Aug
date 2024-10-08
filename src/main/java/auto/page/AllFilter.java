package auto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AllFilter {
    private final SelenideElement filterDialogTitle = $x("//div[text()='Tất cả bộ lọc']");
    private final SelenideElement priceMin = $x("//input[@placeholder='Từ']");
    private final SelenideElement priceMax = $x("//input[@placeholder='Đến']");

    public void verifyAllFilterDialogDisplay() {
        filterDialogTitle.shouldBe(Condition.visible);
    }

    public void enterMinPrice(int input) {
        priceMin.setValue(String.valueOf(input));
    }

    public void enterMaxPrice(int input) {
        priceMax.setValue(String.valueOf(input));
    }

    @Step("Enter Min and Max prices")
    public void enterPriceRange(int min, int max) {
        enterMinPrice(min);
        enterMaxPrice(max);
    }
}
