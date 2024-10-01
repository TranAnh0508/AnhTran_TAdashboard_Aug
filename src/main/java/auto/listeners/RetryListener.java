package auto.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class RetryListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentRetryAnalyzer = result.getMethod().getRetryAnalyzer(result);
        if (currentRetryAnalyzer == null) {
            result.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
        }
    }
}
