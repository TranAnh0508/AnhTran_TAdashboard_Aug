package auto.page;

import auto.data.enums.PanelSettingTypes;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class PanelsPage {
    private final SelenideElement addNewBtn = $x("//a[@href=\"javascript:Dashboard.openAddPanel('');\"]");
    private final String editLinks = "//a[text()='%s']//ancestor::td//following-sibling::td/a[text()='Edit']";
    private final SelenideElement okPopupBtn = $x("//input[@id='OK']");
    private final SelenideElement cancelBtn = $x("//input[@id='Cancel']");
    private final ElementsCollection allControlBtn = $$x("//div[@id = 'main-menu']//a");

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement setDynamicPanelLinks(String panel) {
        String panelLinks = "//div[@id='ccontent']//a[text()='%s']";
        return $x(String.format(panelLinks, panel));
    }

    private SelenideElement setDynamicEditLinks(String panelName) {
        return $x(String.format(editLinks, panelName));
    }

    private SelenideElement setDynamicSettingsForms(PanelSettingTypes type) {
        String settingTypes = "//div[@id='tdSettings']//legend[text()='%s Settings']";
        return $x(String.format(settingTypes, type));
    }

    @Step("Open Add New Panel dialog")
    public void openNewPanelDialog() {
        addNewBtn.shouldBe(Condition.visible);
        addNewBtn.shouldBe(Condition.enabled);
        addNewBtn.click();
    }

    public void cancelDialog() {
        cancelBtn.shouldBe(Condition.enabled);
        cancelBtn.click();
    }

    public void openEditPanelDialog(String panelName) {
        setDynamicEditLinks(panelName).shouldBe(Condition.visible);
        setDynamicEditLinks(panelName).click();
    }

    public boolean isAllControlBtnEnabled() {
        return allControlBtn.filter(Condition.enabled).filter(Condition.visible).isEmpty();
    }
}
