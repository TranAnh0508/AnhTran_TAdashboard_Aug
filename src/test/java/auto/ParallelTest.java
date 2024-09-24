package auto;

import auto.utils.Constants;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ParallelTest {
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            Configuration.browser = "edge";
            Configuration.browserCapabilities = edgeOptions;
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            Configuration.browser = "chrome";
            Configuration.browserCapabilities = chromeOptions;
        }
        Configuration.timeout = 5000;
        open(Constants.DASHBOARD_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.reportsFolder = "allure-results";
    }

    @Test
    public void testOnBrowser() {
        open(Constants.DASHBOARD_URL);
    }
}
