package webdriver.hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.hurt_me_plenty.wait.CustomConditions;

public class CloudGoogleHomePage extends AbstractPage {
    private static final String homePage_URL = "https://cloud.google.com";

    @FindBy(id = "searchbox")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@href, '#') and contains(@class, 'button button-white devsite-suggest-all-results')]")
    private WebElement confirmSearchButton;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openHomePage() {
        driver.get(homePage_URL);
        new WebDriverWait(driver, WAIT_10_SECONDS).until(CustomConditions.jQueryAJAXsComleted());
        return this;
    }

    public CloudGoogleSearchPage searchForTerms(String searchTerms) {
        searchButton.click();
        searchInput.sendKeys(searchTerms);
        confirmSearchButton.click();
        return new CloudGoogleSearchPage(driver, searchTerms);
    }
}
