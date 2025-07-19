package auto.page;

import auto.data.enums.PanelSettingTypes;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ChoosePanelPage {
    private final SelenideElement createNewPanelBtn = $x("//div[@id='container']//span[text()='Create new panel']");

    /**
     * Set value for dynamic xpath
     */
    private ElementsCollection setPanelLinkList(String option) {
        String panelLinkList = "//div[text()='%s']/ancestor::div[@class='pitem']//a";
        return $$x(String.format(panelLinkList, option));
    }

    public List<String> getPanelLinkList(PanelSettingTypes option) {
        return setPanelLinkList(option.value() + "s").stream().map(SelenideElement::getText).collect(Collectors.toList());
    }

    public boolean isLinkListPopulatedCorrectly(List<String> panelLinkList, List<String> correctLinkList) {
        for (String link : panelLinkList) {
            if (!correctLinkList.contains(link)) {
                return false;
            }
        }
        return true;
    }

    public boolean newJul() {
        return true;
    }
}
