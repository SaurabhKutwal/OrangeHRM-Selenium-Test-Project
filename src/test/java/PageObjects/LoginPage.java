package PageObjects;

import UtilityObjects.SuiteBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage extends SuiteBase {
    WebDriver driver;
    WebDriverWait wait;

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

    public String login(String user, String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
        return getErrorMsg();
    }

    String getErrorMsg(){
        try{
            return errorMsg.getText();
        }
        catch(Exception e){
            return "Login Successful";
        }
    }




}
