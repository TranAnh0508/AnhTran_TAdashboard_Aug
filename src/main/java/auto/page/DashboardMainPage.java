package auto.page;

import auto.data.enums.Administer;
import auto.data.enums.GlobalSettings;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardMainPage {
    private final SelenideElement administratorDrop = $x("//div[@class='container']//li//a[@href='#Welcome']");
    private final SelenideElement administerDrop = $x("//div[@class='container']//li//a[@href='#Administer']");
    private final SelenideElement logoutBtn = $x("//a[@href='logout.do']");

    private final SelenideElement choosePanelBtn = $x("//a[@id='btnChoosepanel']");
    private final SelenideElement globalBtn = $x("//li[@class='mn-setting']");

    private SelenideElement setDynamicAdministerDropOptions(Administer option) {
        String dynamicAdministerDropOptions = "//ul[@id='ulAdminister']//a[text()='%s']";
        return $x(String.format(dynamicAdministerDropOptions, option.value()));
    }

    private SelenideElement setDynamicGlobalBtnOptions(GlobalSettings option) {
        String dynamicGlobalBtnOptions = "//li[@class='mn-setting']//a[text()='%s']";
        return $x(String.format(dynamicGlobalBtnOptions, option.value()));
    }

    private SelenideElement setSelectedPage(String pageName) {
        String pageSelected = "//div[@id='main-menu']//a[text()='%s']";
        return $x(String.format(pageSelected, pageName));
    }

    private SelenideElement setSelectedChildPage(String childPageName) {
        String childPageSelected = "//div[@id='main-menu']//li[contains(@class,'haschild')]//li/a[text()='%s']";
        return $x(String.format(childPageSelected, childPageName));
    }

    @Step("Logout")
    public void logout() {
        administratorDrop.shouldBe(Condition.visible);
        administratorDrop.click();
        logoutBtn.shouldBe(Condition.visible);
        logoutBtn.click();
    }

    public int example() {
        return 2;
    }

    @Step("Check the Administrator dropdown is existed")
    public void verifyAdminDropdownDisplayed() {
        administratorDrop.shouldBe(Condition.visible);
        administratorDrop.shouldBe(Condition.enabled);
    }

    public void clickGlobalSettingButton() {
        globalBtn.shouldBe(Condition.enabled);
        globalBtn.click();
    }

    public void clickGlobalSettingOption(GlobalSettings option) {
        setDynamicGlobalBtnOptions(option).shouldBe(Condition.visible);
        setDynamicGlobalBtnOptions(option).shouldBe(Condition.enabled);
        setDynamicGlobalBtnOptions(option).click();
    }

    @Step("Select {option} option")
    public void selectGlobalSettingOption(GlobalSettings option) {
        clickGlobalSettingButton();
        clickGlobalSettingOption(option);
    }

    @Step("Select specified Parent page")
    public void selectPage(String... pageName) {
        SelenideElement page = null;
        for (String name : pageName) {
            page = setSelectedPage(name);
            setSelectedPage(name).shouldBe(Condition.visible);
            setSelectedPage(name).shouldBe(Condition.enabled);
            setSelectedPage(name).hover();
        }
        if (null != page) {
            page.shouldBe(Condition.visible);
            page.shouldBe(Condition.enabled);
            page.click();
        }
    }

    public void deletePage(String... pageName) {
        selectPage(pageName);
        selectGlobalSettingOption(GlobalSettings.DELETE);
    }

    public void verifyGlobalSettingOptionDisplayed(GlobalSettings option) {
        setDynamicGlobalBtnOptions(option).shouldBe(Condition.visible);
    }

    public void verifyPageDisplayed(String pageName) {
        setSelectedPage(pageName).shouldBe(Condition.visible);
    }

    public void verifyChildPageDisplayed(String childPageName) {
        setSelectedChildPage(childPageName).shouldBe(Condition.visible);
    }

    public void clickChoosePanelButton() {
        choosePanelBtn.shouldBe(Condition.enabled);
        choosePanelBtn.click();
    }

    public void clickAdministerDropList() {
        administerDrop.shouldBe(Condition.enabled);
        administerDrop.click();
    }

    public void clickAdministerOption(Administer option) {
        setDynamicAdministerDropOptions(option).shouldBe(Condition.visible);
        setDynamicAdministerDropOptions(option).shouldBe(Condition.enabled);
        setDynamicAdministerDropOptions(option).click();
    }

    @Step("Select {option} option")
    public void selectAdministratorOption(Administer option) {
        clickAdministerDropList();
        clickAdministerOption(option);
    }
}
