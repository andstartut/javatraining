package webdriver.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.i_can_win.wait.CustomConditions;

public class PastebinNewPastePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='selectable']")
    private WebElement divWithPaste;

    public PastebinNewPastePage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, WAIT_10_SECONDS).until(CustomConditions.jQueryAJAXsComleted());
    }

    public String expectedTitleTheNewPastePage() {
        return driver.getTitle();
    }

    public String matchedNewPasteCode() {
        return divWithPaste.getText();
    }
}
