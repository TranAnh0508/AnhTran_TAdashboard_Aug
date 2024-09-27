package auto.mainPage;

import auto.TestBase;
import auto.data.enums.GlobalSettings;
import auto.data.enums.PermanentPages;
import auto.model.Page;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.utils.NameUtils;
import org.testng.annotations.*;

@Listeners
public class VisiblePageTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();

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
        Page pageInfo;

        pageInfo = Page.builder()
                .pageName(NameUtils.getRandomPageName())
                .parentPage(PermanentPages.OVERVIEW.value())
                .isPublic(false)
                .build();

        return new Object[][]{
                {pageInfo}
        };
    }

    @Test(description = "Verify that Public pages can be visible and accessed by all users of working repository", dataProvider = "tc14Data")
    public void visiblePageTest(Page pageInfo) {
//        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        dashboardMainPage.clickGlobalSettingButton();
    }
}
