package testSeleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    private WebDriver wd;

    public Page(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='userName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[5]/div[2]/input[1]")
    WebElement noRobot;
    @FindBy(xpath = "//button[@id='register']")
    WebElement register;
    @FindBy(xpath = "//input[@id='userName']")
    WebElement loginUsername;
    @FindBy(xpath = "//input[@id='password']")
    WebElement loginPassword;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]")
    WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(),'Learning JavaScript Design Patterns')]")
    WebElement learningJavaScript;
    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    WebElement addBook;
    @FindBy(xpath = "//button[@id='gotoStore']")
    WebElement goToBookStore;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/span[1]/*[1]")
    WebElement deleteBook;
    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    WebElement deleteOKButton;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[3]/button[1]")
    WebElement deleteAllBooks;
    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    WebElement deleteBooksOKButton;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement elementsButton;
    @FindBy(id = "item-2")
    WebElement radioButton;

    public void inputFirstName() {
        firstName.sendKeys("Marko");
    }
    public void inputLastName() {
        lastName.sendKeys("Djukic");
    }
    public void inputUserName() {
        userName.sendKeys("cosavic");
    }
    public void inputPassword() {
        password.sendKeys("Pass123@@\n");
    }
    public void checkNoRobot() {
        noRobot.click();
    }
    public void clickRegister() {
        register.click();
    }
    public void login() throws InterruptedException {
        loginUsername.sendKeys("cosavic");
        loginPassword.sendKeys("Pass123@@\n");
        Thread.sleep(3000);
        loginButton.click();
    }
    public void testAddBook() {
        learningJavaScript.click();
        JavascriptExecutor jse = (JavascriptExecutor) wd;
        jse.executeScript("arguments[0].scrollIntoView()", addBook);
        addBook.click();
    }
    public void testDeleteBook() throws InterruptedException {
        deleteBook.click();
        Thread.sleep(2000);
        deleteOKButton.click();
    }
    public void testDeleteAllBooks() throws InterruptedException {
        deleteAllBooks.click();
        Thread.sleep(2000);
        WebElement deleteBooksOKButton = wd.findElement(By.xpath("//button[@id='closeSmallModal-ok']"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", deleteBooksOKButton);
        Thread.sleep(500);;
        deleteBooksOKButton.click();
    }
    public void radioButton() throws InterruptedException {
        elementsButton.click();
        WebElement radioButton = wd.findElement(By.id("item-2"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", radioButton);
        radioButton.click();
    }
}