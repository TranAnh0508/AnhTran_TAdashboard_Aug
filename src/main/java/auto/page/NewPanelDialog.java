package auto.page;

import auto.data.enums.Administer;
import auto.data.enums.PanelSettingTypes;
import auto.model.Panel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

public class NewPanelDialog {
    //Display Settings
    private final String typeRadioBtn = "//div[@id='div_panelPopup']//label[contains(text(), '%s')]/input";
    private final SelenideElement dataProfileDropList = $x("//select[@id='cbbProfile']");
    private final SelenideElement displayNameTextBox = $x("//input[@name='txtDisplayName']");
    private final String settingsForms = "//div[@id='tdSettings']//legend[text()='%s Settings']";
    private final SelenideElement okPanelConfigPopupBtn = $x("//div[@aria-labelledby='ui-dialog-title-div_panelConfigurationDlg']//input[@id='OK']");
    private final SelenideElement cancelPanelConfigPopupBtn = $x("//div[@aria-labelledby='ui-dialog-title-div_panelConfigurationDlg']//input[@id='Cancel']");

    //Chart Settings
    private final SelenideElement chartTitleTextBox = $x("//input[@id='txtChartTitle']");
    private final SelenideElement seriesDropList = $x("//select[@id='cbbSeriesField']");

    /**
     * Set value for dynamic xpath
     */
    private SelenideElement getDynamicTypeRadioBtn(PanelSettingTypes option) {
        return $x(String.format(typeRadioBtn, option.value()));
    }

    /**
     * Step to fill the New Panel Dialog
     */
    public void enterDisplayName(String displayName) {
        if (!Objects.equals(displayNameTextBox.getText(), displayName)) {
            displayNameTextBox.setValue(displayName);
        }
    }
    public void selectSeries(String series) {
        if (!Objects.equals(seriesDropList.getSelectedOption().getValue(), series)) {
            seriesDropList.selectOption(series);
        }
    }

    @Step("Fill the new panel info into the dialog")
    public void fillPanelInfoIntoDialog(Panel info) {
        if (Objects.nonNull(info.getDisplayName())) {
            enterDisplayName(info.getDisplayName());
        }
        if (Objects.nonNull(info.getSeries())) {
            selectSeries(info.getSeries().value());
        }
    }

    public void cancelPanelDialog() {
        cancelPanelConfigPopupBtn.shouldBe(Condition.enabled);
        cancelPanelConfigPopupBtn.click();
    }

    public void clickOkPanelDialogBtn() {
        okPanelConfigPopupBtn.shouldBe(Condition.enabled);
        okPanelConfigPopupBtn.click();
    }
    public void completePanelInfoDialog(Panel info) {
        fillPanelInfoIntoDialog(info);
        clickOkPanelDialogBtn();
    }
}
