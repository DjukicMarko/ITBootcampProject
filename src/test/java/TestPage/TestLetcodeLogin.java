package TestPage;

import Page.LetcodeLogin;
import Page.LetcodeRegister;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestLetcodeLogin {
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
    public void testUserLogin() throws InterruptedException {
        LetcodeLogin lcl = new LetcodeLogin(wd);
        lcl.userLogin();
        Thread.sleep(2000);
        WebElement signOut = wd.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
        Assert.assertTrue(signOut.getText().equals("Sign out"), "Login was successful.");
    }
    @Test
    public void testDropDown() throws InterruptedException {
        LetcodeLogin lcl = new LetcodeLogin(wd);
        lcl.dropDown();
        Thread.sleep(2000);
        WebElement fruitDropDown = wd.findElement(By.xpath("//select[@id='fruits']"));
        Select select = new Select(fruitDropDown);
        select.selectByVisibleText("Apple");
        WebElement superheroes = wd.findElement(By.xpath("//select[@id='superheros']"));
        Select select1 = new Select(superheroes);
        select1.selectByValue("sm");
        WebElement programingLanguage = wd.findElement(By.xpath("//select[@id='lang']"));
        Select select2 = new Select(programingLanguage);
        select2.selectByIndex(4);
        WebElement country = wd.findElement(By.xpath("//select[@id='country']"));
        Select select3 = new Select(country);
        WebElement selectedCountry = select3.getFirstSelectedOption();
        System.out.println(selectedCountry.getText());
        Thread.sleep(3000);
    }
    @Test
    public void testInputSection() throws InterruptedException {
        LetcodeLogin lcl = new LetcodeLogin(wd);
        lcl.inputSection();
        WebElement whatIsInside = wd.findElement(By.xpath("//input[@id='getMe']"));
        whatIsInside.getAttribute("ortonikc");
        WebElement disabledField = wd.findElement(By.xpath("//input[@id='noEdit']"));
        if (disabledField.isEnabled()) {
            System.out.println("Edit field is enabled.");
        } else {
            System.out.println("Edit field is disabled.");
        }
        WebElement readonly = wd.findElement(By.xpath("//input[@id='dontwrite']"));
        String readonlyString = readonly.getAttribute("readonly");
        Assert.assertNotNull(readonlyString);
        Thread.sleep(4000);
    }
}
