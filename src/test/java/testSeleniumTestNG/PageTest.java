package testSeleniumTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class PageTest {
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
        wd.get("https://demoqa.com/register");
        Assert.assertTrue(wd.getCurrentUrl().equals("https://demoqa.com/register"), "You are on the correct page.");
        Page register = new Page(wd);
        register.inputFirstName();
        register.inputLastName();
        register.inputUserName();
        register.inputPassword();
        register.clickRegister();
    }
    @Test
    public void testLogin() throws InterruptedException {
        wd.get("https://demoqa.com/login");
        Assert.assertTrue(wd.getCurrentUrl().equals("https://demoqa.com/login"), "You are on the correct page.");
        Page login = new Page(wd);
        login.login();
        WebElement successfulLogin = wd.findElement(By.xpath("//label[@id='userName-value']"));
        Assert.assertTrue(successfulLogin.getText().equals("cosavic"), "Login successful.");
    }
    @Test
    public void addBook() throws InterruptedException {
        Page addBook = new Page(wd);
        wd.get("https://demoqa.com/login");
        addBook.inputUserName();
        addBook.inputPassword();
        addBook.loginButton.click();
        wd.get("https://demoqa.com/books");
        addBook.testAddBook();
        wd.get("https://demoqa.com/profile");
        WebElement bookAdded = wd.findElement(By.xpath("//a[contains(text(),'Learning JavaScript Design Patterns')]"));
        Assert.assertTrue(bookAdded.getText().equals("Learning JavaScript Design Patterns"), "Book was added successfully.");
    }
    @Test
    public void deleteBook() throws InterruptedException {
        Page deleteBook = new Page(wd);
        wd.get("https://demoqa.com/login");
        deleteBook.inputUserName();
        deleteBook.inputPassword();
        deleteBook.loginButton.click();
        wd.get("https://demoqa.com/profile");
        deleteBook.testDeleteBook();
    }
    @Test
    public void deleteBooks() throws InterruptedException {
        Page deleteBooks = new Page(wd);
        wd.get("https://demoqa.com/login");
        deleteBooks.inputUserName();
        deleteBooks.inputPassword();
        deleteBooks.loginButton.click();
        wd.get("https://demoqa.com/profile");
        Thread.sleep(2000);
        deleteBooks.testDeleteAllBooks();
    }
    @Test
    public void radioButton() throws InterruptedException {
        Page radioButton = new Page(wd);
        wd.get("https://demoqa.com/");
        WebElement elementsButton = wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", elementsButton);
        Thread.sleep(500);
        radioButton.radioButton();
        WebElement header = wd.findElement(By.id("head"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", header);
        Thread.sleep(2000);
        WebElement impressiveButton = wd.findElement(By.id("impressiveButton"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", impressiveButton);
        impressiveButton.click();
//        impressiveButton.click();
//        boolean isSelected = impressiveButton.isSelected();
//        if (isSelected == false) {
//            System.out.println("Impressive button is not clicked.");
//        }
    }
}
