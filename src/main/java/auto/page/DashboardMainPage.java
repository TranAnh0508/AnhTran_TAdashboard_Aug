package auto.page;

import auto.data.enums.Administer;
import auto.data.enums.GlobalSettings;
import auto.utils.NameUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardMainPage {
    private final SelenideElement administratorDrop = $x("//div[@class='container']//li//a[@href='#Welcome']");
    private final SelenideElement administerDrop = $x("//div[@class='container']//li//a[@href='#Administer']");
    private final String dynamicAdministerDropOptions = "//ul[@id='ulAdminister']//a[text()='%s']";
    private final SelenideElement logoutBtn = $x("//a[@href='logout.do']");

    private final SelenideElement choosePanelBtn = $x("//a[@id='btnChoosepanel']");
    private final SelenideElement globalBtn = $x("//li[@class='mn-setting']");
    private final String dynamicGlobalBtnOptions = "//li[@class='mn-setting']//a[text()='%s']";
    private final SelenideElement newCreatedPage = $x("//a[text()='Overview']/following::a[1]");

    private final String pageSelected = "//div[@id='main-menu']//a[text()='%s']";
    private final String pageNextPage = "//div[@id='main-menu']//li[a[text()='%s']]/following-sibling::li[a[text()='%s']]";
    private final String pageChildPage = "//div[@id='main-menu']//a[text()='%s']//ancestor::li//following::li//a[text()='%s']";
    private final String childPageSelected = "//div[@id='main-menu']//li[contains(@class,'haschild')]//li/a[text()='%s']"; //Test Child

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement setDynamicAdministerDropOptions(Administer option) {
        return $x(String.format(dynamicAdministerDropOptions, option.value()));
    }

    private SelenideElement setDynamicGlobalBtnOptions(GlobalSettings option) {
        return $x(String.format(dynamicGlobalBtnOptions, option.value()));
    }

    private SelenideElement setSelectedPage(String pageName) {
        return $x(String.format(pageSelected, pageName));
    }

    private SelenideElement setPageNextPage(String previousPage, String nextPage) {
        return $x(String.format(pageNextPage, NameUtils.trimName(previousPage), NameUtils.trimName(nextPage)));
    }

    private SelenideElement setPageChildPage(String parentPage, String childPage) {
        return $x(String.format(pageChildPage, NameUtils.trimName(parentPage), NameUtils.trimName(childPage)));
    }

    private SelenideElement setSelectedChildPage(String childPageName) {
        return $x(String.format(childPageSelected, childPageName));
    }

    @Step("Logout")
    public void logout() {
        administratorDrop.shouldBe(Condition.visible);
        administratorDrop.click();
        logoutBtn.shouldBe(Condition.visible);
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

    public boolean isGlobalSettingOptionDisplayed(GlobalSettings option) {
        return setDynamicGlobalBtnOptions(option).isDisplayed();
    }

    public boolean isPageDisplayed(String pageName) {
        setSelectedPage(pageName).shouldBe(Condition.visible);
        return setSelectedPage(pageName).isDisplayed();
    }

    public boolean isChildPageDisplayed(String childPageName) {
        setSelectedChildPage(childPageName);
        return setSelectedChildPage(childPageName).isDisplayed();
    }

    /**
     * Action with Choose Panel button
     */
    public void clickChoosePanelButton() {
        choosePanelBtn.shouldBe(Condition.enabled);
        choosePanelBtn.click();
    }

    /**
     * Action with Administer Drop List
     */
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
