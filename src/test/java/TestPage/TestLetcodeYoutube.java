package TestPage;

import Page.LetcodeYoutube;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestLetcodeYoutube {
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
    public void testYouTube() {
        wd.get("https://letcode.in/");
        LetcodeYoutube lcy = new LetcodeYoutube(wd);
        lcy.youTubeButton();
    }
}
