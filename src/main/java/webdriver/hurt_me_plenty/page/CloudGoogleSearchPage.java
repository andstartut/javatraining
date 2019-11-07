package webdriver.hurt_me_plenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CloudGoogleSearchPage extends AbstractPage {

    private final String splitRedex = "\\s";
    private String searchTerms;
    private String defaultLocator = "//a[contains(@class,'gs-title')%s]";
    private String containsPart = " and contains(.,'%s')";

    public CloudGoogleSearchPage(WebDriver driver, String searchTerms) {
        super(driver);
        this.searchTerms = searchTerms;
    }

    public CloudGoogleCalculatorPage openGoogleCloudPlatformPricingCalculator() {
        Wait<WebDriver> waitSearchResult = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result list was extended!");

        List<WebElement> resultSearchWithTerm = waitSearchResult.until(new Function<WebDriver, List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(By.xpath(buildLocatorForSearch()));
            }
        });
        resultSearchWithTerm.get(0).click();
        return new CloudGoogleCalculatorPage(driver);
    }

    private String buildLocatorForSearch() {
        String partWithSearchTerm = "";
        String[] terms = searchTerms.split(splitRedex);
        for (String term : terms) {
            partWithSearchTerm += String.format(containsPart, term);
        }
        String locatorForSearch = String.format(defaultLocator, partWithSearchTerm);
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }
}
