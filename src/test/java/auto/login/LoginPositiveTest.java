package auto.login;

import auto.TestBase;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.utils.Assertion;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import auto.page.LoginPage;

@Listeners
public class LoginPositiveTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();

    private final User user = User.getAdminAcc();

    @Test(description = "Verify that the user can login successfully with a valid username and password")
    public void loginPositiveTest() {
        loginPage.login(user);
        Assertion.assertTrue(dashboardMainPage.isAdminDropdownDisplayed(), "Verify that the user login successfully");
    }

    @AfterMethod
    public void afterMethodPositive() {
        dashboardMainPage.logout();
    }
}
