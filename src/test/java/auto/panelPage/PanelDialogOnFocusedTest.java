package auto.panelPage;

import auto.TestBase;
import auto.data.enums.Administer;
import auto.listeners.RetryAnalyzer;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.page.PanelsPage;
import auto.utils.Assertion;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class PanelDialogOnFocusedTest extends TestBase {
    private LoginPage loginPage = new LoginPage();
    private DashboardMainPage dashboardMainPage = new DashboardMainPage();
    private PanelsPage panelsPage = new PanelsPage();

    private User user = User.getAdminAcc();

    @BeforeMethod(description = "Set up objects")
    public void setUpObjects() {
        loginPage.login(user);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        dashboardMainPage.logout();
    }

    @Test(description = "Verify that when \"Add New Panel\" form is on focused all other control/form is disabled or locked.", retryAnalyzer = RetryAnalyzer.class)
    public void TC_28() {
        dashboardMainPage.selectAdministratorOption(Administer.PANELS);
        panelsPage.openNewPanelDialog();

        Assertion.assertFalse(panelsPage.isAllControlBtnEnabled(), "All control/form are disabled or locked when Add New Panel dialog is opening");
        panelsPage.cancelDialog();
    }
}
