package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class Test {
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
}
