package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LetcodeNewTab {
    private WebDriver wd;

    public LetcodeNewTab(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
    @FindBy(xpath = "/html/body/app-root/app-main/section[2]/div/div[4]/div/div[2]/div/div/a")
    WebElement letXPathButton;

    public void letXPathButton() throws AWTException, InterruptedException {
        Actions action = new Actions(wd);
        action.contextClick(letXPathButton).build().perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
    }
}
