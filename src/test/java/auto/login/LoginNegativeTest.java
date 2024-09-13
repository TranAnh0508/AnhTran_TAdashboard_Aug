package auto.login;

import auto.TestBase;
import auto.utils.Assertion;
import org.testng.annotations.Test;
import auto.page.LoginPage;

public class LoginNegativeTest extends TestBase{
    private LoginPage loginPage = new LoginPage();

    @Test(description = "Verify that user fails to login with invalid credentials")
    public void loginNegativeTest() {
        loginPage.login("", "");
//        Assertion.assertTrue(dashboardMainPage.isAdminDropdownDisplayed(), "Verify that the user login successfully");
    }
}
