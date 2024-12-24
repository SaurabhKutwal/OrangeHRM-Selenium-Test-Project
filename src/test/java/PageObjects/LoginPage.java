package PageObjects;

import UtilityObjects.SuiteBase;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static UtilityObjects.PageUtility.takeScreenshot;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage extends SuiteBase {
    WebDriver driver;
    WebDriverWait wait;

    String evidencePath;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.driver.manage().window().maximize();
    }

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//p[text() = 'Invalid credentials']")
    WebElement errorMsg;

    public String login(String caseId,String user, String pass) throws IOException {
        userName.sendKeys(user);
        password.sendKeys(pass);
        takeScreenshot(driver,evidencePath,"1.Login Credentials");
        loginBtn.click();
        String msg = getErrorMsg();
        takeScreenshot(driver,evidencePath,"2.Response");
        return msg;
    }

    public void tempLogin(String user, String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
        String msg = getErrorMsg();
    }

    String getErrorMsg(){
        try{
            return errorMsg.getText();
        }
        catch(Exception e){
            return "Login Successful";
        }
    }

    public void setEvidencePath(String evidencePath){
        this.evidencePath = evidencePath;
    }


}
