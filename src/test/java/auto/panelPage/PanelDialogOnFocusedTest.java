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
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();
    private final PanelsPage panelsPage = new PanelsPage();

    private final User user = User.getAdminAcc();

    @Test(description = "Verify that when \"Add New Panel\" form is on focused all other control/form is disabled or locked.", retryAnalyzer = RetryAnalyzer.class)
    public void TC_28() {
        loginPage.login(user);
        dashboardMainPage.selectAdministratorOption(Administer.PANELS);
        panelsPage.openNewPanelDialog();

        Assertion.assertFalse(panelsPage.isAllControlBtnEnabled(), "All control/form are disabled or locked when Add New Panel dialog is opening");
        panelsPage.cancelDialog();
    }
}
