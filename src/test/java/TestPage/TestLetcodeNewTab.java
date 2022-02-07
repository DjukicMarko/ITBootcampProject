package TestPage;

import Page.LetcodeNewTab;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class TestLetcodeNewTab {
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
        wd.quit();
        Runtime.getRuntime().exec("taskkill /F /IM cromedriver.exe /T");
    }
    @Test
    public void testLetXPath() throws InterruptedException, AWTException {
        wd.get("https://letcode.in/");
        LetcodeNewTab lnt = new LetcodeNewTab(wd);
        WebElement letXPath = wd.findElement(By.xpath("//a[contains(text(),'LetXPath')]"));
        ((JavascriptExecutor)wd).executeScript("arguments[0].scrollIntoView(true);", letXPath);
        lnt.letXPathButton();
        Thread.sleep(2000);
        ArrayList<String> tab = new ArrayList<String>(wd.getWindowHandles());
        wd.switchTo().window(tab.get(1));
        WebElement openSourceProject = wd.findElement(By.xpath("/html/body/app-root/app-letx/div/div[2]/div[1]/div[2]/article"));
        ((JavascriptExecutor)wd).executeScript("arguments[0].scrollIntoView(true);", openSourceProject);
        String bcClr = openSourceProject.getCssValue("background-color");
        System.out.println("Background color of selected div as rgba value is " + bcClr);
        String hex = Color.fromString(bcClr).asHex();
        System.out.println("Background color of selected div as hex value is " + hex);
        Thread.sleep(3000);
    }
}
