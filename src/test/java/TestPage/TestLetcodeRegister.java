package TestPage;

import Page.LetcodeRegister;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestLetcodeRegister extends TestListenerAdapter {
    WebDriver wd;

    @BeforeTest
    public void init() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
    }
    @AfterSuite
    public void close() throws IOException {
        wd.close();
        Runtime.getRuntime().exec("taskkill /F /IM cromedriver.exe /T");
    }
    @Test
    public void testRegister() throws InterruptedException {
        LetcodeRegister lcr = new LetcodeRegister(wd);
        wd.get("https://letcode.in/test");
        lcr.userSignUp("John Doe", "johndoe5@gmail.com", "password");
        WebElement signOut = wd.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
        Assert.assertTrue(signOut.getText().equals("Sign out"), "Signing in was successful.");
    }
    @Test
    public void testRegisterUnhappyPath() throws IOException, InterruptedException {
        LetcodeRegister lcr = new LetcodeRegister(wd);
        wd.get("https://letcode.in/test");
        File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        lcr.userSignupUnhappyPath("John Doe", "johndoe21@gmail.com", "password");
        try {
            WebElement signOut = wd.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
        try {
            WebElement signOut = wd.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\ortak\\OneDrive\\Dokumenti\\ITBootcamp\\Screenshoots\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
