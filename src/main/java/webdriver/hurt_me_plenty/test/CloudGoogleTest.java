package webdriver.hurt_me_plenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.hurt_me_plenty.page.CloudGoogleCalculatorPage;
import webdriver.hurt_me_plenty.page.CloudGoogleHomePage;

public class CloudGoogleTest {

    WebDriver driver;
    private final String searchTerm = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test/*(invocationCount = 10)*/
    public void verifyThatNewCloudHasCreated() {
        CloudGoogleCalculatorPage cloudGoogleCalculatorPage = new CloudGoogleHomePage(driver)
                .openHomePage()
                .searchForTerms(searchTerm)
                .openGoogleCloudPlatformPricingCalculator()
                .selectTab("Compute Engine")
                .enterNumberOfInstances("4")
                .selectRegularVMClass()
                .selectOperationSystem()
                .selectInstanceTypeN1Standart8()
                .selectAdGPUs()
                .selectNumberOfGPUs()
                .selectGPUType()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommitedUsage()
                .addToEstimate();

        Assert.assertTrue(cloudGoogleCalculatorPage.confirmFinalData().contains("VM class: regular"), "Result didn't contain Regular");
        Assert.assertTrue(cloudGoogleCalculatorPage.confirmFinalData().contains("Instance type: n1-standard-8"), "Result didn't contain n1-standard-8");
        Assert.assertTrue(cloudGoogleCalculatorPage.confirmFinalData().contains("Region: Frankfurt"), "Result didn't contain  Frankfurt");
        Assert.assertTrue(cloudGoogleCalculatorPage.confirmFinalData().contains("Total available local SSD space 2x375 GB"), "Result didn't contain 2x375");
        Assert.assertTrue(cloudGoogleCalculatorPage.confirmFinalData().contains("Commitment term: 1 Year"), "Result didn't contain 1 Year");
        Assert.assertTrue(cloudGoogleCalculatorPage.totalCost().contains("1,082.77"), "Result didn't contain 1,082.77");
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.close();
        driver = null;
    }
}
