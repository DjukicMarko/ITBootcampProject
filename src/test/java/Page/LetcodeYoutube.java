package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LetcodeYoutube {
    private WebDriver wd;

    public LetcodeYoutube(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
    @FindBy(xpath = "//app-header/nav[1]/div[1]/div[2]/div[1]/a[5]")
    WebElement youTube;

    public void youTubeButton() {
        youTube.click();
    }
}
