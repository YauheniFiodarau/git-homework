package by.fiodarau.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestCalcListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("test started: " + iInvokedMethod.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("test finished [" + iTestResult.getStatus() + "] " +
                iInvokedMethod.getTestMethod().getMethodName() + "\n");
    }

}
