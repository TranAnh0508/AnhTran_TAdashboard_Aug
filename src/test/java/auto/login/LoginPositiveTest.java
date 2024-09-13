package auto.login;

import auto.TestBase;
import auto.utils.Assertion;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import auto.page.LoginPage;

@Listeners
public class LoginPositiveTest extends TestBase {
    private LoginPage loginPage = new LoginPage();

    @Test(description = "Verify that the user can login successfully with a valid username and password")
    public void loginPositiveTest() {
        loginPage.login("administrator", "");
//        Assertion.assertTrue(dashboardMainPage.isAdminDropdownDisplayed(), "Verify that the user login successfully");
    }
}
