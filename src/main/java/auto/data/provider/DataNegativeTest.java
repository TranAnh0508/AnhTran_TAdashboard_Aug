package auto.data.provider;

import auto.model.User;
import auto.utils.MessageUtils;
import org.testng.annotations.DataProvider;

public class DataNegativeTest {
    @DataProvider(name = "Invalid Credentials")
    public static Object[][] invalidAccounts() {
        return new Object[][]{
                {User.getInvalidAcc("invalidBothUsernameAndPass"), MessageUtils.getAlertMessage("invalidInfo")}
        };
    }
}
