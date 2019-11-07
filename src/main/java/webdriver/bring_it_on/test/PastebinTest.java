package webdriver.bring_it_on.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.bring_it_on.page.PastebinHomePage;
import webdriver.bring_it_on.page.PastebinNewPastePage;

public class PastebinTest {
    private WebDriver driver;
    private final String inputCode =
            "git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";
    private final String selectHighlightingSyntax = "Bash";
    private final String selectExpiration = "10 Minutes";
    private final String inputName = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyThatNewPastePageHasCreated() {
        PastebinNewPastePage pastebinHomePage = new PastebinHomePage(driver)
                .openHomePage()
                .createNewPaste(inputCode, selectHighlightingSyntax, selectExpiration, inputName);
        String expectedTitleTheNewPastePage = pastebinHomePage.expectedTitleTheNewPastePage();
        String matchedNewPasteCode = pastebinHomePage.matchedNewPasteCode();

        Assert.assertTrue(expectedTitleTheNewPastePage.contains(inputName), "Title the New Paste page didn't contain: " + inputName);
        Assert.assertTrue(expectedTitleTheNewPastePage.contains(selectHighlightingSyntax), "Syntax the new Paste page didn't match: " + selectHighlightingSyntax);
        Assert.assertTrue(matchedNewPasteCode.contains(inputCode), "New Paste page didn't contain code: " + inputCode);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
