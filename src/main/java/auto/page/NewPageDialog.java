package auto.page;

import auto.model.Page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

public class NewPageDialog {
    private final SelenideElement pageNameTbx = $x("//input[@id='name']");
    private final SelenideElement parentPageNameDropList = $x("//select[@id='parent']");
    private final SelenideElement numberOfColumnOption = $x("//select[@id='columnnumber']");
    private final SelenideElement displayAfterDropList = $x("//select[@id='afterpage']");
    private final SelenideElement publicCbx = $x("//input[@id='ispublic']");
    private final SelenideElement okPopupBtn = $x("//input[@id='OK']");

    public void enterPageName(String pageName) {
        pageNameTbx.setValue(pageName);
    }

    public void selectParentPage(String parentPage) {
        if (!Objects.equals(parentPageNameDropList.getSelectedOption().getValue(), parentPage)) {
            parentPageNameDropList.selectOption(parentPage);
        }
    }

    public void selectNumberOfColumns(int numberOfColumns) {
        if (!Objects.equals(numberOfColumnOption.getSelectedOption().getValue(), numberOfColumns)) {
            numberOfColumnOption.selectOption(numberOfColumns);
        }
    }

    public void selectPreviousPage(String previousPage) {
        if (!Objects.equals(displayAfterDropList.getSelectedOption().getValue(), previousPage)) {
            displayAfterDropList.selectOptionByValue(previousPage);
        }
    }

    public void checkIsPublic(boolean isPublic) {
        publicCbx.setSelected(isPublic);
    }

    public void clickDialogOkButton() {
        okPopupBtn.shouldBe(Condition.visible);
        okPopupBtn.click();
    }

    @Step("Fill the new page info into the dialog")
    public void fillPageInfoIntoDialog(Page info) {
        if (Objects.nonNull(info.getPageName())) {
            enterPageName(info.getPageName());
        }
        if (Objects.nonNull(info.getParentPage())) {
            selectParentPage(info.getParentPage());
        }
        if (Objects.nonNull(info.getNumberOfColumns())) {
            selectNumberOfColumns(info.getNumberOfColumns());
        }
        if (Objects.nonNull(info.getDisplayAfter())) {
            selectPreviousPage(info.getDisplayAfter());
        }
        checkIsPublic(info.isPublic());
    }

    public void completePageInfoDialog(Page info) {
        fillPageInfoIntoDialog(info);
        clickDialogOkButton();
    }
}
