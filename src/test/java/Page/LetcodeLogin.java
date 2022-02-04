package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetcodeLogin {
    private WebDriver wd;

    public LetcodeLogin(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement login;
    @FindBy(xpath = "//body/app-root[1]/app-signin[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
    WebElement inputFirstName;
    @FindBy(xpath = "//body/app-root[1]/app-signin[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")
    WebElement inputPassword;
    @FindBy(xpath = "//button[contains(text(),'LOGIN')]")
    WebElement loginButton;
    @FindBy(xpath = "//a[@id='testing']")
    WebElement workSpace;
    @FindBy(xpath = "//a[contains(text(),'Drop-Down')]")
    WebElement dropDown;
    @FindBy(xpath = "//select[@id='fruits']")
    WebElement selectFruit;
    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    WebElement input;
    @FindBy(xpath = "//input[@id='fullName']")
    WebElement inputsFirstName;
    @FindBy(xpath = "//input[@id='join']")
    WebElement appendText;
    @FindBy(xpath = "//input[@id='clearMe']")
    WebElement clear;


    public void userLogin() {
        wd.get("https://letcode.in/");
        login.click();
        inputFirstName.sendKeys("johndoe@gmail.com");
        inputPassword.sendKeys("password");
        loginButton.click();
    }
    public void dropDown() {
        wd.get("https://letcode.in/");
        login.click();
        inputFirstName.sendKeys("johndoe@gmail.com");
        inputPassword.sendKeys("password");
        loginButton.click();
        workSpace.click();
        dropDown.click();
        selectFruit.click();
    }
    public void inputSection() throws InterruptedException {
        wd.get("https://letcode.in/");
        login.click();
        inputFirstName.sendKeys("johndoe@gmail.com");
        inputPassword.sendKeys("password");
        loginButton.click();
        workSpace.click();
        input.click();
        inputsFirstName.sendKeys("John Doe");
        appendText.clear();
        Thread.sleep(2000);
        appendText.sendKeys("I am a good fella.");
        clear.clear();
    }
}
