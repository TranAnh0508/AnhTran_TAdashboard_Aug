package auto.mainPage;

import auto.TestBase;
import auto.data.enums.GlobalSettings;
import auto.data.provider.DataVisiblePageTest;
import auto.listeners.RetryAnalyzer;
import auto.model.Page;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.page.NewPageDialog;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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

    @Test(description = "Verify that Public pages can be visible and accessed by all users of working repository", dataProvider = "TC_14", dataProviderClass = DataVisiblePageTest.class, retryAnalyzer = RetryAnalyzer.class)
    public void TC_14(Page firstPageInfo) {
        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(firstPageInfo);

        dashboardMainPage.logout();

        loginPage.login(user);
        dashboardMainPage.verifyPageDisplayed(firstPageInfo.getTrimPageName());
//        Assertion.assertTrue(dashboardMainPage.verifyPageDisplayed(firstPageInfo.getTrimPageName()), "Newly added page is visible");
    }
}
