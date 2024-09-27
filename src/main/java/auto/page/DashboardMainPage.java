package auto.page;

import auto.data.enums.Administer;
import auto.data.enums.GlobalSettings;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardMainPage {
    private final SelenideElement administratorDrop = $(By.xpath("//div[@class='container']//li//a[@href='#Welcome']"));
    private final SelenideElement administerDrop = $(By.xpath("//div[@class='container']//li//a[@href='#Administer']"));
    private final String dynamicAdministerDropOptions = "//ul[@id='ulAdminister']//a[text()='%s']";
    private final SelenideElement logoutBtn = $(By.xpath("//a[@href='logout.do']"));

    private final SelenideElement choosePanelBtn = $x("//a[@id='btnChoosepanel']");
    private final SelenideElement globalBtn = $(By.xpath("//li[@class='mn-setting']"));
    private final String dynamicGlobalBtnOptions = "xpath=//li[@class='mn-setting']//a[text()='%s']";
    private final SelenideElement newCreatedPage = $x("//a[text()='Overview']/following::a[1]");

    /**
     * Set value for dynamic xpath
     * @param option
     * @return
     */
    private final SelenideElement getDynamicAdministerDropOptions(Administer option) {
        return $(String.format(dynamicAdministerDropOptions, option.value()));
    }

    private final SelenideElement getDynamicGlobalBtnOptions(GlobalSettings option) {
        return $(String.format(dynamicGlobalBtnOptions, option.value()));
    }

    @Step("Logout")
    public void logout() {
        administratorDrop.click();
        logoutBtn.click();
    }

    @Step("Check the Administrator dropdown is existed")
    public boolean isAdminDropdownDisplayed() {
        administratorDrop.shouldBe(Condition.enabled);
        return administratorDrop.isDisplayed();
    }

    /**
     * Action with Global Setting Menu
     */
    public void clickGlobalSettingButton() {
        globalBtn.shouldBe(Condition.enabled);
        globalBtn.click();
    }

    public void clickGlobalSettingOption(GlobalSettings option) {
        getDynamicGlobalBtnOptions(option).shouldBe(Condition.enabled);
        getDynamicGlobalBtnOptions(option).click();
    }

    @Step("Select {option} option")
    public void selectGlobalSettingOption(GlobalSettings option) {
        clickGlobalSettingButton();
        clickGlobalSettingOption(option);
    }

    public boolean isGlobalSettingOptionDisplayed(GlobalSettings option) {
        return getDynamicGlobalBtnOptions(option).isDisplayed();
    }
}
