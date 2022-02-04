package TestNGListenerConcept;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class MojSkrinsoter extends TestListenerAdapter {
    WebDriver wd;

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test je pao.");
        File srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\ortak\\OneDrive\\Dokumenti\\ITBootcamp\\TestingLetcode\\src\\test\\java\\screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
