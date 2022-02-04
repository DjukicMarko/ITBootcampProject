package TestPage;

import Page.LetcodeYoutube;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        Assert.assertTrue(wd.getCurrentUrl().equals("https://accounts.google.com/signin/v2/identifier?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Den%26next%3D%252Fchannel%252FUCNcnqL0P17hISKlOxTjkJ0g%253Fsub_confirmation%253D1%2526feature%253Dsubscribe-embed-click%26feature%3Dsubscribe&hl=en&flowName=GlifWebSignIn&flowEntry=ServiceLogin"), "The URL is correct.");
    }
}
