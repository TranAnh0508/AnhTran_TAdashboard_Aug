package auto.login;

import auto.TestBase;
import auto.listeners.RetryListener;
import auto.model.User;
import auto.listeners.RetryAnalyzer;
import auto.utils.DriverUtils;
import auto.utils.MessageUtils;
import com.codeborne.selenide.Selenide;
import com.sun.net.httpserver.Authenticator;
import org.testng.Assert;
import org.testng.annotations.*;
import auto.page.LoginPage;

@Listeners
public class LoginNegativeTest extends TestBase {
    private  LoginPage loginPage = new LoginPage();

    @DataProvider(name = "Invalid Credentials")
    public static Object[][] invalidAccounts() {
        return new Object[][]{
                {User.getInvalidAcc("invalidBothUsernameAndPass"), MessageUtils.getAlertMessage("blankInfo")}
        };
    }

    @Test(description = "Verify that user fails to login with invalid credentials", dataProvider = "Invalid Credentials", retryAnalyzer = RetryAnalyzer.class)
    public void loginNegativeTest(User user, String errorMessage) {
        loginPage.login(user);
        Assert.assertEquals(DriverUtils.getAlertText(), errorMessage, "Error message appears");
        DriverUtils.acceptAlert();
    }

//    @AfterMethod(alwaysRun = true)
//    public void afterMethodNegative() {
//        Selenide.closeWindow();
//    }
}
