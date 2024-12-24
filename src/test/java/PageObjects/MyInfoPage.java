package PageObjects;

import UtilityObjects.SuiteBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static UtilityObjects.PageUtility.takeScreenshot;
import static org.openqa.selenium.support.PageFactory.initElements;

public class MyInfoPage extends SuiteBase {

    WebDriver driver;
    WebDriverWait wait;

    String evidencePath;

    public MyInfoPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        initElements(driver,this);
        this.driver.manage().window().maximize();
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

    @FindBy(xpath = "//label[text() = 'Nationality']/parent::div/parent::div//div[text()='-- Select --']")
    WebElement nationality;

    @FindBy(xpath = "//label[text() = 'Marital Status']/parent::div/parent::div//div[text()='-- Select --']")
    WebElement maritalStatus;

    @FindBy(xpath = "//label[text() = 'Date of Birth']/parent::div/parent::div//child::input")
    WebElement dob;

    @FindBy(xpath = "//label[text() = 'Male']/input")
    WebElement maleChkBox;

    @FindBy(xpath = "//label[text() = 'Female']/input")
    WebElement femaleChkBox;

    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-content']/child::div[1]/form")
    WebElement form;

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







}
