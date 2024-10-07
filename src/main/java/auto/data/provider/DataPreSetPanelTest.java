package auto.data.provider;

import auto.data.enums.ChartSeries;
import auto.model.Page;
import auto.model.Panel;
import auto.utils.NameUtils;
import org.testng.annotations.DataProvider;

public class DataPreSetPanelTest {
    @DataProvider(name = "TC_27")
    public static Object[][] tc27Data() {
        Page page;
        Panel panel;

        page = Page.builder()
                .pageName(NameUtils.getRandomPageName())
                .isPublic(false)
                .build();
        panel = Panel.builder()
                .displayName(NameUtils.getRandomPanelName())
                .series(ChartSeries.NAME)
                .build();

        return new Object[][]{
                {page, panel}
        };
    }
}
