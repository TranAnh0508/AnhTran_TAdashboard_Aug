package auto.utils;

import com.atlassian.sal.api.auth.Authenticator;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.Assert;

import static com.atlassian.sal.api.auth.Authenticator.Result.Status.FAILED;

public class Assertion {
    public static void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
            Allure.step(message);
        } catch (AssertionError ex) {
            Allure.step(message, Status.FAILED);
            throw ex;
        }
    }

    public static void assertFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
            Allure.step(message);
        } catch (AssertionError ex) {
            Allure.step(message, Status.FAILED);
            throw ex;
        }
    }
}