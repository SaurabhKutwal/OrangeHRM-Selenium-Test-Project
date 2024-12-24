package PageObjects;

import UtilityObjects.SuiteBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class DashboardPage extends SuiteBase {
    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        initElements(driver,this);
        driver.manage().window().maximize();
    }

    public void goTo(String menu){
        driver.findElement(By.xpath("//span[text() = '"+menu+"']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = '"+menu+"']/parent::a[contains(@class,'active')]")));
    }
}
