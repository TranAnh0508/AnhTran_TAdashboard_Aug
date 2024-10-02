package auto.dataProfilePage;

import auto.TestBase;
import auto.data.enums.Administer;
import auto.listeners.RetryAnalyzer;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import org.testng.annotations.*;

@Listeners
public class ListedProfilesTest extends TestBase {
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

    @Test(description = "Verify that Data Profiles are listed alphabetically", retryAnalyzer = RetryAnalyzer.class)
    public void TC_67() {
        dashboardMainPage.selectAdministratorOption(Administer.DATA_PROFILES);
    }
}
