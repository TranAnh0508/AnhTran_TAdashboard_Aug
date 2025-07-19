package auto.page;

import auto.model.Panel;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

public class NewPanelDialog {
    private final SelenideElement displayNameTextBox = $x("//input[@name='txtDisplayName']");
    private final SelenideElement okPanelConfigPopupBtn = $x("//div[@aria-labelledby='ui-dialog-title-div_panelConfigurationDlg']//input[@id='OK']");

    private final SelenideElement seriesDropList = $x("//select[@id='cbbSeriesField']");

    public void enterDisplayName(String displayName) {
        if (!Objects.equals(displayNameTextBox.getText(), displayName)) {
            displayNameTextBox.setValue(displayName);
        }
    }

    public void selectSeries(String series) {
        if (!Objects.equals(seriesDropList.getSelectedOption().getValue(), series)) {
            seriesDropList.selectOptionContainingText(series);
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

    public void clickOkPanelDialogBtn() {
        okPanelConfigPopupBtn.shouldBe(Condition.enabled);
        okPanelConfigPopupBtn.click();
    }

    public void completePanelInfoDialog(Panel info) {
        fillPanelInfoIntoDialog(info);
        clickOkPanelDialogBtn();
    }
}
