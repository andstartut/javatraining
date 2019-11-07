package webdriver.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.i_can_win.wait.CustomConditions;

public class PastebinHomePage extends AbstractPage {
    private static final String pastebin_URL = "https://pastebin.com";

    @FindBy(xpath = "//*[@name='paste_format']")
    private WebElement syntaxHighlightingSelect;

    @FindBy(name = "paste_expire_date")
    private WebElement pasteExpirationSelect;

    @FindBy(xpath = "//*[@id='paste_code']")
    private WebElement pasteInput;

    @FindBy(name = "paste_name")
    private WebElement pasteNameInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openHomePage() {
        driver.get(pastebin_URL);
        new WebDriverWait(driver, WAIT_10_SECONDS).until(CustomConditions.jQueryAJAXsComleted());
        return this;
    }

    public PastebinNewPastePage createNewPaste(String inputCode, String inputName) {
        pasteInput.sendKeys(inputCode);
        new Select(pasteExpirationSelect).selectByIndex(1);
        pasteNameInput.sendKeys(inputName);
        submitButton.click();
        return new PastebinNewPastePage(driver);
    }
}
