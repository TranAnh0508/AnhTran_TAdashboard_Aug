package auto.mainPage;

import auto.TestBase;
import auto.data.enums.GlobalSettings;
import auto.model.Page;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.page.NewPageDialog;
import auto.listeners.RetryAnalyzer;
import auto.utils.Assertion;
import auto.utils.NameUtils;
import org.testng.annotations.*;

@Listeners
public class VisiblePageTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();
    private final NewPageDialog newPageDialog = new NewPageDialog();

    private final User user = User.getAdminAcc();

    @BeforeMethod(description = "Set up objects")
    public void setUpObjects() {
        loginPage.login(user);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodPositive() {
        dashboardMainPage.logout();
    }

    @DataProvider(name = "tc14Data")
    public static Object[][] tc14Data() {
        Page firstPageInfo;

        firstPageInfo = Page.builder()
                .pageName(NameUtils.getRandomPageName())
                .isPublic(true)
                .build();

        return new Object[][]{
                {firstPageInfo}
        };
    }

    @Test(description = "Verify that Public pages can be visible and accessed by all users of working repository", dataProvider = "tc14Data", retryAnalyzer = RetryAnalyzer.class)
    public void visiblePageTest(Page firstPageInfo) {
        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(firstPageInfo);

        dashboardMainPage.logout();

        loginPage.login(user);
        Assertion.assertTrue(dashboardMainPage.isPageDisplayed(firstPageInfo.getTrimPageName()), "Newly added page is visible");
    }
}
