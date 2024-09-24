package auto;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import auto.utils.Constants;
import org.testng.annotations.Parameters;

public class TestBase {

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {
//        Configuration.browser = "chrome";
//        Configuration.timeout = 5000;
//        open(Constants.DASHBOARD_URL);
//        WebDriverRunner.getWebDriver().manage().window().maximize();

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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
