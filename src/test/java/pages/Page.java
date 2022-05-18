package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    private WebDriver wd;

    public Page(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
}
