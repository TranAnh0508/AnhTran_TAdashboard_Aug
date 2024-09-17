package auto.listeners;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("Tests started on {}", context.getCurrentXmlTest().getParameter("platform"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test case \"{} - {}\" is started", result.getMethod().getMethodName(),
                result.getMethod().getDescription());
    }

    // Chụp và đính kèm ảnh màn hình vào Allure Report
    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    // Đính kèm mã nguồn của trang hiện tại vào Allure Report (tùy chọn)
    @Attachment(value = "Page Source", type = "text/html")
    public String attachPageSource() {
        return WebDriverRunner.getWebDriver().getPageSource();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Chụp ảnh màn hình khi test thất bại
        attachScreenshot();

        // Đính kèm thêm log hoặc thông tin khác nếu cần
        attachPageSource();
    }
}
