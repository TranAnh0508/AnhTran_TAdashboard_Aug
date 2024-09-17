package auto.login;

import auto.TestBase;
import auto.model.User;
import auto.utils.DriverUtils;
import auto.utils.MessageUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import auto.page.LoginPage;

@Listeners
public class LoginNegativeTest extends TestBase {
    private LoginPage loginPage = new LoginPage();

    @DataProvider(name = "Invalid Credentials")
    public static Object[][] invalidAccounts() {
        return new Object[][]{
                {User.getInvalidAcc("invalidBothUsernameAndPass"), MessageUtils.getAlertMessage("invalidInfo")},
                {User.getInvalidAcc("empty"), MessageUtils.getAlertMessage("empty")}
        };
    }

    @Test(description = "Verify that user fails to login with invalid credentials", dataProvider = "Invalid Credentials")
    public void loginNegativeTest(User user, String errorMessage) {
        loginPage.login(user);
        Assert.assertEquals(DriverUtils.getAlertText(), errorMessage, "Error message appears");
    }

    @AfterMethod
    public void afterMethodNegative() {
        DriverUtils.acceptAlert();
    }
}
