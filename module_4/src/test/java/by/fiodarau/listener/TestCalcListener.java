package by.fiodarau.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestCalcListener implements ITestListener {

    private final static String SEPARATOR = "-------------------------------------------------";
    private final static String FINAL_SEPARATOR = "=================================================";
    private final static Logger LOGGER = LogManager.getLogger(TestCalcListener.class);

    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("on Test Start: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        printTestResults(iTestResult);
    }

    public void onFinish(ITestContext context) {
        LOGGER.info("Completed executing test " + context.getName(), true);
        LOGGER.info(FINAL_SEPARATOR);

    }

    public void onTestFailure(ITestResult iTestResult) {
        printTestResults(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
//        LOGGER.info("Test was skipped!");
        printTestResults(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info(SEPARATOR);
    }

    private void printTestResults(ITestResult result) {
        LOGGER.info("Test Method resides in " + result.getTestClass().getName(), true);
        if (result.getParameters().length != 0) {
            StringBuilder params = new StringBuilder();
            for (Object parameter : result.getParameters()) {
                params.append(parameter.toString()).append(", ");
            }
            LOGGER.info("Test Method had the following parameters : " + params, true);
        }
        String status = null;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = "Pass";
                break;
            case ITestResult.FAILURE:
                status = "Failed";
                break;
            case ITestResult.SKIP:
                status = "Skipped";
        }
        LOGGER.info("Test Status: " + status, true);
        LOGGER.info(SEPARATOR);
    }
}
