package auto;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import auto.utils.Constants;

public class TestBase {

    @BeforeMethod
    public void setUp() {
        // Cấu hình Selenide
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        open(Constants.DASHBOARD_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Đóng trình duyệt sau mỗi test
        closeWebDriver();
    }
}
