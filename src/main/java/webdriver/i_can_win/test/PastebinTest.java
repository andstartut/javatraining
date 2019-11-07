package webdriver.i_can_win.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.i_can_win.page.PastebinHomePage;

public class PastebinTest {
    private WebDriver driver;
    private final String inputCode = "Hello from WebDriver";
    private final String inputName = "helloweb";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste() {
        new PastebinHomePage(driver)
                .openHomePage()
                .createNewPaste(inputCode, inputName);

    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
