package PageObjects;

import UtilityObjects.SuiteBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static UtilityObjects.PageUtility.takeScreenshot;
import static UtilityObjects.PageUtility.takeScreenshotOfWebEle;
import static org.openqa.selenium.support.PageFactory.initElements;

public class MyInfoPage extends SuiteBase {

    WebDriver driver;
    WebDriverWait wait;

    String evidencePath;
    Actions actions;

    public MyInfoPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        initElements(driver,this);
        this.driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "middleName")
    WebElement middleName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//label[text() = 'Employee Id']/parent::div/parent::div//child::input")
    WebElement empId;

    @FindBy(xpath = "//label[text() = 'Other Id']/parent::div/parent::div//child::input")
    WebElement otherId;

    @FindBy(xpath = "//label[text() = \"Driver's License Number\"]/parent::div/parent::div//child::input")
    WebElement driverLicenseNum;

    @FindBy(xpath = "//label[text() = 'License Expiry Date']/parent::div/parent::div//child::input")
    WebElement licenseExpDate;

    @FindBy(xpath = "//label[text() = 'Nationality']/parent::div/following-sibling::div/div/div/div[1]")
    WebElement nationality;

    @FindBy(xpath = "//label[text() = 'Nationality']/parent::div/parent::div//div[@role = 'listbox']")
    WebElement nationalityOptions;

    @FindBy(xpath = "//label[text() = 'Marital Status']/parent::div/following-sibling::div/div/div/div[1]")
    WebElement maritalStatus;

    @FindBy(xpath = "//label[text() = 'Marital Status']/parent::div/parent::div//div[@role = 'listbox']")
    WebElement maritalStatusOptions;

    @FindBy(xpath = "//label[text() = 'Date of Birth']/parent::div/parent::div//child::input")
    WebElement dob;

    @FindBy(xpath = "//input[@type='radio'and @value = '1']/parent::label")
    WebElement maleChkBox;

    @FindBy(xpath = "//input[@type='radio'and @value = '2']/parent::label")
    WebElement femaleChkBox;

    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-content']/child::div[1]/form")
    WebElement form;

    @FindBy(xpath = "//div[@role = 'tablist']")
    WebElement tabList;

    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-content']/child::div[1]/form//button")
    WebElement saveBtn;

    @FindBy(xpath = "//p[@class = 'oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement toasterMsg;

    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee']//img[@alt = 'profile picture']")
    WebElement profileIcon;

    public String checkField(String field) throws IOException {

        wait.until(ExpectedConditions.visibilityOf(form));

        takeScreenshot(driver,evidencePath,field);

        switch (field) {
            case "FirstName":
                if (firstName.isEnabled()) return "Enable";
                else return "Disable";
            case "MiddleName":
                if (middleName.isEnabled()) return "Enable";
                else return "Disable";
            case "LastName":
                if (lastName.isEnabled()) return "Enable";
                else return "Disable";
            case "EmployeeId":
                if (empId.isEnabled()) return "Enable";
                else return "Disable";
            case "OtherId":
                if (otherId.isEnabled()) return "Enable";
                else return "Disable";
            case "Driver License Number":
                if (driverLicenseNum.isEnabled()) return "Enable";
                else return "Disable";
            case "License Expiry Date":
                if (licenseExpDate.isEnabled()) return "Enable";
                else return "Disable";
            case "Nationality":
                if (nationality.isEnabled()) return "Enable";
                else return "Disable";
            case "Marital Status":
                if (maritalStatus.isEnabled()) return "Enable";
                else return "Disable";
            case "Date Of Birth":
                if (dob.isEnabled()) return "Enable";
                else return "Disable";
            case "Male Checkbox":
                if (maleChkBox.isEnabled()) return "Enable";
                else return "Disable";
            case "Female Checkbox":
                if (femaleChkBox.isEnabled()) return "Enable";
                else return "Disable";
            default:
                return "No Such Field";
        }
    }

    public void setEvidencePath(String evidencePath){
        this.evidencePath = evidencePath;
    }

    public void goTo(String section){
        driver.findElement(By.xpath(tabList+"//a[text() = '"+section+"']")).click();
        wait.until(ExpectedConditions.attributeContains(By.xpath(tabList+"//a[text() = '"+section+"']"),"class","orangehrm-tabs-item --active"));
    }

    public void updateField(String field, String value) throws IOException {
        switch (field) {
            case "FirstName":
                if (firstName.isEnabled()){
                    firstName.click();
                    for(int i=1;i<30;i++){
                        firstName.sendKeys(Keys.BACK_SPACE);
                    }
                    firstName.sendKeys(value);
                }
                break;
            case "MiddleName":
                if (middleName.isEnabled()){
                    middleName.click();
                    for(int i=1;i<30;i++){
                        middleName.sendKeys(Keys.BACK_SPACE);
                    }
                    middleName.sendKeys(value);
                }
                break;
            case "LastName":
                if (lastName.isEnabled()){
                    lastName.click();
                    for(int i=1;i<30;i++){
                        lastName.sendKeys(Keys.BACK_SPACE);
                    }
                    lastName.sendKeys(value);
                }
                break;
            case "EmployeeId":
                if (empId.isEnabled()){
                    empId.sendKeys(value);
                }
                break;
            case "OtherId":
                if (otherId.isEnabled()){
                    otherId.click();
                    for(int i=1;i<30;i++){
                        otherId.sendKeys(Keys.BACK_SPACE);
                    }
                    otherId.sendKeys(value);
                }
                break;
            case "Driver License Number":
                if (driverLicenseNum.isEnabled()){
                    driverLicenseNum.sendKeys(value);
                }
                break;
            case "License Expiry Date":
                if (licenseExpDate.isEnabled()){
                    String year = value.substring(0,4);
                    ArrayList<String> months = new ArrayList<>(List.of("January","February","March","April","May","June","July",
                            "August","September","October","November","December"));
                    String month = months.get(Integer.parseInt(value.substring(5,7))-1);
                    String day = value.substring(8,10);
                    licenseExpDate.click();
                    driver.findElement(By.xpath("//div[@class = 'oxd-calendar-selector-month-selected']")).click();
                    driver.findElement(By.xpath("//li[text() = '"+month+"']")).click();
                    driver.findElement(By.xpath("//div[@class = 'oxd-calendar-selector-year-selected']")).click();
                    driver.findElement(By.xpath("//li[text() = '"+year+"']")).click();
                    driver.findElement(By.xpath("//div[text() = '"+day+"']")).click();
                }
                break;
            case "Nationality":
                if (nationality.isEnabled()){
                    nationality.click();
                    wait.until(ExpectedConditions.visibilityOf(nationalityOptions));
                    driver.findElement(By.xpath("//span[text() = '"+value+"']")).click();
                }
                break;
            case "Marital Status":
                if (maritalStatus.isEnabled()){
                    maritalStatus.click();
                    wait.until(ExpectedConditions.visibilityOf(maritalStatusOptions));
                    driver.findElement(By.xpath("//span[text() = '"+value+"']")).click();
                }
                break;
            case "Date Of Birth":
                if (dob.isEnabled()){
                    dob.sendKeys(value);
                }
                break;
            case "Male Checkbox":
                if (maleChkBox.isEnabled()){
                    maleChkBox.click();
                }
                break;
            case "Female Checkbox":
                if (femaleChkBox.isEnabled()){
                    maleChkBox.click();
                }
                break;
        }
        takeScreenshot(driver,evidencePath,field);
    }

    public String saveForm() throws InterruptedException {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return saveBtn.getLocation().x == 1496 && saveBtn.getLocation().y == 693;
            }
        });

        saveBtn.click();
        wait.until(ExpectedConditions.visibilityOf(toasterMsg));
        return toasterMsg.getText();
    }

    public String uploadPic() throws InterruptedException, IOException {
        profileIcon.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'employee-image-wrapper']"))));
        Thread.sleep(5000);
        takeScreenshot(driver,evidencePath,"BeforeUpdate");
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(System.getProperty("user.dir") +
                "//src//test//resources//ProfilePic.png");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        wait.until(ExpectedConditions.visibilityOf(toasterMsg));
        String msg = toasterMsg.getText();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'employee-image-wrapper']"))));
        Thread.sleep(5000);
        takeScreenshot(driver,evidencePath,"AfterUpdate");
        wait.until(ExpectedConditions.visibilityOf(toasterMsg));
        Thread.sleep(2000);

        return msg;
    }
}


