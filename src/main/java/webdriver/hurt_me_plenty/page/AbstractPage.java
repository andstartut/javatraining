package webdriver.hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_10_SECONDS = 10;
    protected final int WAIT_20_SECONDS = 20;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
