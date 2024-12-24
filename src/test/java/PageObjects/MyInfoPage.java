package PageObjects;

import UtilityObjects.SuiteBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MyInfoPage extends SuiteBase {

    WebDriver driver;
    WebDriverWait wait;

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

    public String checkField(String field){
        if (field.equals("FirstName")) {
            if(firstName.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("MiddleName")) {
            if(middleName.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("LastName")) {
            if(lastName.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("EmployeeId")) {
            if(empId.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("OtherId")) {
            if(otherId.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("Driver License Number")) {
            if(driverLicenseNum.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("License Expiry Date")) {
            if(licenseExpDate.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("Nationality")) {
            if(nationality.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("Marital Status")) {
            if(maritalStatus.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("Date Of Birth")) {
            if(dob.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("Male Checkbox")) {
            if(maleChkBox.isEnabled()) return "Enable";
            else return "Disable";
        }
        else if (field.equals("Female Checkbox")) {
            if(femaleChkBox.isEnabled()) return "Enable";
            else return "Disable";
        }
        else{
            return "No Such Field";
        }
    }







}
