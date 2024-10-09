package auto;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import auto.utils.Constants;

public class TestBase {

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("edge")) {
            Configuration.browser = "edge";
        } else if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        }

        Configuration.timeout = 5000;
        open(Constants.TIKI_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.reportsFolder = "allure-results";
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
