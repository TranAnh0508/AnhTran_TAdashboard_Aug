package auto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PanelsPage {
    private final SelenideElement addNewBtn = $x("//a[@href=\"javascript:Dashboard.openAddPanel('');\"]");
    private final SelenideElement cancelBtn = $x("//input[@id='Cancel']");
    private final ElementsCollection allControlBtn = $$x("//div[@id = 'main-menu']//a");

    private SelenideElement setDynamicEditLinks(String panelName) {
        String editLinks = "//a[text()='%s']//ancestor::td//following-sibling::td/a[text()='Edit']";
        return $x(String.format(editLinks, panelName));
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
