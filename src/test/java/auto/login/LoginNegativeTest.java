package auto.login;

import auto.TestBase;
import auto.model.User;
import auto.listeners.RetryAnalyzer;
import auto.utils.AlertUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import auto.page.LoginPage;
import auto.data.provider.DataNegativeTest;

@Listeners
public class LoginNegativeTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();

    //Force failed to test the Test Retry
    @Test(description = "Verify that user fails to login with invalid credentials", dataProvider = "Invalid Credentials", dataProviderClass = DataNegativeTest.class, retryAnalyzer = RetryAnalyzer.class)
    public void loginNegativeTest(User user, String errorMessage) {
        loginPage.login(user);
        Assert.assertEquals(AlertUtils.getAlertText(), errorMessage, "Error message appears");
        AlertUtils.acceptAlert();
    }
}
