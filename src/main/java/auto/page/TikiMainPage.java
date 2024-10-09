package auto.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TikiMainPage {
    private final SelenideElement searchTbx = $x("//input[@data-view-id='main_search_form_input']");
    private final SelenideElement searchBtn = $x("//button[@data-view-id='main_search_form_button']");

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement setDynamicCategoryLinks(String input) {
        String categoryLinks = "//div[contains(@class,'styles__StyledSideBar')]//div[text()='Danh mục']//following-sibling::div//div[@title='%s']";
        return $x(String.format(categoryLinks, input));
    }

    @Step("Enter value in Search text box")
    public void enterCharactersIntoSearchBox(String input) {
        searchTbx.setValue(input);
    }

    @Step("Click 'Tìm kiếm' button")
    public void clickSearchBtn() {
        searchBtn.click();
    }

    public void searchProduct(String input) {
        enterCharactersIntoSearchBox(input);
        clickSearchBtn();
    }

    public void clickOnCategory(String input) {
        setDynamicCategoryLinks(input).click();
    }
}
