package auto.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtils {
    //AlertUtils
    @Step("Accept the Alert")
    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(Constants.TIMESOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        alert.accept();
    }

    @Step("Get the text from Alert")
    public static String getAlertText() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(Constants.TIMESOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        return alert.getText();
    }
}
