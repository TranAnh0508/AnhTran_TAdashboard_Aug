package auto.login;

import auto.TestBase;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.listeners.RetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class LoginPositiveTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();

    private final User user = User.getAdminAcc();

    @Test(description = "Verify that the user can login successfully with a valid username and password", retryAnalyzer = RetryAnalyzer.class)
    public void loginPositiveTest() {
        loginPage.login(user);
        dashboardMainPage.verifyAdminDropdownDisplayed();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodPositive() {
        dashboardMainPage.logout();
    }
}
