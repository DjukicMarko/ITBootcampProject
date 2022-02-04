package TestNGListenerConcept;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshootListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {

    }
}
