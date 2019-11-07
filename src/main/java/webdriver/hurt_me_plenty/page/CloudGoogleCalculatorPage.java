package webdriver.hurt_me_plenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CloudGoogleCalculatorPage extends AbstractPage {

    private static final String OPERATING_SYSTEM_SELECT_LOCATOR = "select_value_label_46";
    private static final String OPERATING_SYSTEM_OPTION_LOCATOR = "select_option_55";
    private static final String MACHINE_CLASS_SELECT_LOCATOR = "select_value_label_47";
    private static final String MACHINE_CLASS_OPTION_LOCATOR = "select_option_67";
    private static final String MACHINE_TYPE_SELECT_LOCATOR = "select_76";
    private static final String MACHINE_TYPE_OPTION_LOCATOR = "select_option_217";
    private static final String ADD_GPU_LOCATOR = "//*[@aria-label='Add GPUs']";
    private static final String NUMBER_OF_GPUS_SELECT_LOCATOR = "select_348";
    private static final String NUMBER_OF_GPUS_OPTION_LOCATOR = "select_option_353";
    private static final String TYPE_GPU_SELECT_LOCATOR = "select_350";
    private static final String TYPE_GPU_OPTION_LOCATOR = "select_option_360";
    private static final String LOCAL_SSD_SELECT_LOCATOR = "select_78";
    private static final String LOCAL_SSD_OPTION_LOCATOR = "select_option_171";
    private static final String DATACENTER_LOCATION_SELECT_LOCATOR = "select_80";
    private static final String DATACENTER_LOCATION_OPTION_LOCATOR = "select_option_185";
    private static final String COMMITED_USAGE_SELECT_LOCATOR = "select_85";
    private static final String COMMITED_USAGE_OPTION_LOCATOR = "select_option_83";
    private String mainLocatorForTabs = "//md-tab-item";
    private String containsPart = "/div[contains(@title, '%s')]";

    @FindBy(id = "myFrame")
    private WebElement iFrame;

    @FindBy(name = "quantity")
    private WebElement numberOfInstanceInput;

    @FindBy(id = OPERATING_SYSTEM_SELECT_LOCATOR)
    private WebElement operatingSystemSelect;

    @FindBy(id = OPERATING_SYSTEM_OPTION_LOCATOR)
    private WebElement operatingSystemSelectOption;

    @FindBy(id = MACHINE_CLASS_SELECT_LOCATOR)
    private WebElement machineClassSelect;

    @FindBy(id = MACHINE_CLASS_OPTION_LOCATOR)
    private WebElement machineClassSelectOption;

    @FindBy(id = MACHINE_TYPE_SELECT_LOCATOR)
    private WebElement machineTypeSelect;

    @FindBy(id = MACHINE_TYPE_OPTION_LOCATOR)
    private WebElement machineTypeSelectOption;

    @FindBy(xpath = ADD_GPU_LOCATOR)
    private WebElement addGPUs;

    @FindBy(id = NUMBER_OF_GPUS_SELECT_LOCATOR)
    private WebElement numberOfGPUsSelect;

    @FindBy(id = NUMBER_OF_GPUS_OPTION_LOCATOR)
    private WebElement numberOfGPUsOption;

    @FindBy(id = TYPE_GPU_SELECT_LOCATOR)
    private WebElement typeGPUSelect;

    @FindBy(id = TYPE_GPU_OPTION_LOCATOR)
    private WebElement typeGPUOption;

    @FindBy(id = LOCAL_SSD_SELECT_LOCATOR)
    private WebElement localSSDSelect;

    @FindBy(id = LOCAL_SSD_OPTION_LOCATOR)
    private WebElement localSSDOption;

    @FindBy(id = DATACENTER_LOCATION_SELECT_LOCATOR)
    private WebElement datacenterlocationSelect;

    @FindBy(id = DATACENTER_LOCATION_OPTION_LOCATOR)
    private WebElement datacenterlocationOption;

    @FindBy(id = COMMITED_USAGE_SELECT_LOCATOR)
    private WebElement commitedUsageSelect;

    @FindBy(id = COMMITED_USAGE_OPTION_LOCATOR)
    private WebElement commitedUsageOption;

    @FindBy(xpath = "//*[contains(@ng-disabled,'ComputeEngineForm.$invalid || !listingCtrl.isGceAvailabele')]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement totalCostDiv;

    protected CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }


    public CloudGoogleCalculatorPage selectTab(String tabName) {
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        driver.findElement(By.xpath(buildLocatorForTabs(tabName))).click();
        return this;
    }

    public CloudGoogleCalculatorPage enterNumberOfInstances(String number) {
        numberOfInstanceInput.sendKeys(number);
        return this;
    }

    public CloudGoogleCalculatorPage selectOperationSystem() {
        operatingSystemSelect.click();
        operatingSystemSelectOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectRegularVMClass() {
        machineClassSelect.click();
        machineClassSelectOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectInstanceTypeN1Standart8() {
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(MACHINE_TYPE_SELECT_LOCATOR)));
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(datacenterlocationSelect));
        machineTypeSelect.click();
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(MACHINE_TYPE_OPTION_LOCATOR)));
        machineTypeSelectOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectAdGPUs() {
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_GPU_LOCATOR)));
        addGPUs.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectNumberOfGPUs() {
        numberOfGPUsSelect.click();
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(NUMBER_OF_GPUS_OPTION_LOCATOR)));
        numberOfGPUsOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectGPUType() {
        typeGPUSelect.click();
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(TYPE_GPU_OPTION_LOCATOR)));
        typeGPUOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectLocalSSD() {
        localSSDSelect.click();
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(LOCAL_SSD_OPTION_LOCATOR)));
        localSSDOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectDatacenterLocation() {
        datacenterlocationSelect.click();
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(DATACENTER_LOCATION_OPTION_LOCATOR)));
        datacenterlocationOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectCommitedUsage() {
        commitedUsageSelect.click();
        new WebDriverWait(driver, WAIT_10_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(COMMITED_USAGE_OPTION_LOCATOR)));
        commitedUsageOption.click();
        return this;
    }

    public CloudGoogleCalculatorPage addToEstimate() {
        addToEstimateButton.click();
        return this;
    }

    public String totalCost() {
        String totalCost = totalCostDiv.getText();
        return totalCost;
    }

    private String buildLocatorForTabs(String tabName) {
        String locatorForTab = "";
        List<WebElement> listOfTabs = driver.findElements(By.xpath(mainLocatorForTabs));
        for (int i = 1; i <= listOfTabs.size(); i++) {
            locatorForTab = mainLocatorForTabs + "[" + i + "]"
                    + String.format(containsPart, tabName);
            if (driver.findElements(By.xpath(locatorForTab)).size() > 0) {
                break;
            }else{
                System.out.println("DEBUG: Not found the locator for the tab");
            }
        }
        System.out.println("DEBUG: The final locator for tab: " + locatorForTab);
        return locatorForTab;
    }

    public List<String> confirmFinalData() {
        List<WebElement> listOfFinalLines = driver
                .findElements(By.xpath("//*[contains(@class,'md-list-item-text ng-binding')]"));
        List<String> finalDataList = new ArrayList<>();
        for (WebElement element : listOfFinalLines) {
            finalDataList.add(element.getText());
        }
        System.out.println("DEBUG: List of the final data: " + finalDataList);
        return finalDataList;
    }
}
