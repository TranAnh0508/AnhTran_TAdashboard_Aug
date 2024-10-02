package auto.panelPage;

import auto.TestBase;
import auto.data.enums.ChartSeries;
import auto.data.enums.GlobalSettings;
import auto.data.enums.PanelSettingTypes;
import auto.listeners.RetryAnalyzer;
import auto.utils.Constants;
import auto.model.Page;
import auto.model.Panel;
import auto.model.User;
import auto.page.*;
import auto.utils.Assertion;
import auto.utils.JsonUtils;
import auto.utils.NameUtils;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;

@Listeners
public class PreSetPanelsTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();
    private final NewPageDialog newPageDialog = new NewPageDialog();
    private NewPanelDialog newPanelDialog = new NewPanelDialog();
    private ChoosePanelPage choosePanelPage = new ChoosePanelPage();

    private final User user = User.getAdminAcc();

    @BeforeMethod(description = "Set up objects")
    public void setUpObjects() {
        loginPage.login(user);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        dashboardMainPage.logout();
    }

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

    @Test(description = "Verify that when \"Choose panels\" form is expanded all pre-set panels are populated and sorted correctly ", dataProvider = "TC_27", retryAnalyzer = RetryAnalyzer.class)
    public void TC_27(Page page, Panel panel) {
        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(page);

        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.CREATE_PANEL);
        newPanelDialog.completePanelInfoDialog(panel);

        dashboardMainPage.clickChoosePanelButton();

        List<String> expectedChartsLink = JsonUtils.to(Constants.PANEL_PATH, "chartLinkList", List.class);
        List<String> comparedChartsLink = choosePanelPage.getPanelLinkList(PanelSettingTypes.CHART);
        boolean isChartsCorrect = choosePanelPage.isLinkListPopulatedCorrectly(expectedChartsLink, comparedChartsLink);
        Assertion.assertTrue(isChartsCorrect, PanelSettingTypes.CHART.value() + " link list is populated correctly");
        List<String> sortedChartsLink = (List<String>) comparedChartsLink.stream().sorted(Comparator.naturalOrder());
        boolean isChartsSorted = choosePanelPage.isLinkListPopulatedCorrectly(expectedChartsLink, sortedChartsLink);
        Assertion.assertTrue(isChartsSorted, PanelSettingTypes.CHART.value() + " link list is sorted correctly");

        List<String> expectedIndicatorLink = JsonUtils.to(Constants.PANEL_PATH, "indicatorLinkList", List.class);
        List<String> comparedIndicatorLink = choosePanelPage.getPanelLinkList(PanelSettingTypes.INDICATOR);
        boolean isIndicatorsCorrect = choosePanelPage.isLinkListPopulatedCorrectly(expectedIndicatorLink, comparedIndicatorLink);
        Assertion.assertTrue(isIndicatorsCorrect, PanelSettingTypes.INDICATOR.value() + " link list is populated and sorted correctly");
        List<String> sortedIndicatorLink = (List<String>) comparedIndicatorLink.stream().sorted(Comparator.naturalOrder());
        boolean isIndicatorSorted = choosePanelPage.isLinkListPopulatedCorrectly(expectedIndicatorLink, sortedIndicatorLink);
        Assertion.assertTrue(isIndicatorSorted, PanelSettingTypes.INDICATOR.value() + " link list is sorted correctly");

        List<String> expectedReportsLink = JsonUtils.to(Constants.PANEL_PATH, "reportsLinkList", List.class);
        List<String> comparedReportsLink = choosePanelPage.getPanelLinkList(PanelSettingTypes.REPORT);
        boolean isReportsCorrect = choosePanelPage.isLinkListPopulatedCorrectly(expectedReportsLink, comparedReportsLink);
        Assertion.assertTrue(isReportsCorrect, PanelSettingTypes.REPORT.value() + " link list is populated and sorted correctly");
        List<String> sortedReportsLink = (List<String>) comparedReportsLink.stream().sorted(Comparator.naturalOrder());
        boolean isReportsSorted = choosePanelPage.isLinkListPopulatedCorrectly(expectedReportsLink, sortedReportsLink);
        Assertion.assertTrue(isReportsSorted, PanelSettingTypes.REPORT.value() + " link list is sorted correctly");

        List<String> expectedHeatMapsLink = JsonUtils.to(Constants.PANEL_PATH, "heatMapsLinkList", List.class);
        List<String> comparedHeatMapsLink = choosePanelPage.getPanelLinkList(PanelSettingTypes.HEAT_MAP);
        boolean isHeatMapsCorrect = choosePanelPage.isLinkListPopulatedCorrectly(expectedHeatMapsLink, comparedHeatMapsLink);
        Assertion.assertTrue(isHeatMapsCorrect, PanelSettingTypes.HEAT_MAP.value() + " link list is populated and sorted correctly");
        List<String> sortedHeatMapsLink = (List<String>) comparedHeatMapsLink.stream().sorted(Comparator.naturalOrder());
        boolean isHeatMapsSorted = choosePanelPage.isLinkListPopulatedCorrectly(expectedHeatMapsLink, sortedHeatMapsLink);
        Assertion.assertTrue(isHeatMapsSorted, PanelSettingTypes.HEAT_MAP.value() + " link list is sorted correctly");
    }
}
