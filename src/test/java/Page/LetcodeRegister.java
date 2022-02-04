package Page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class LetcodeRegister {
    private WebDriver wd;

    public LetcodeRegister(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    WebElement signUp;
    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "pass")
    WebElement inputPassword;
    @FindBy(id = "agree")
    WebElement agreeCheckbox;
    @FindBy(xpath = "//button[contains(text(),'SIGN UP')]")
    WebElement signUpButton;

    public void userSignUp(String fullName, String email, String password) throws InterruptedException {
        signUp.click();
        inputName.sendKeys(fullName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        agreeCheckbox.click();
        Thread.sleep(2000);
        signUpButton.click();
    }
    public void userSignupUnhappyPath(String fullName, String email, String password) throws IOException, InterruptedException {
        signUp.click();
        inputName.sendKeys(fullName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        Thread.sleep(2000);
        signUpButton.click();
    }
}
