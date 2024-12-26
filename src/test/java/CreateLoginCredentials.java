import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateLoginCredentials {

    @Test
    public void getCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        driver.findElement(By.xpath("//span[text() = 'PIM']")).click();

        driver.findElement(By.xpath("//div[@class = 'orangehrm-header-container']//button")).click();

        //"//div[@class = 'orangehrm-employee-container']"

        driver.findElement(By.name("firstName")).sendKeys("User123");
        driver.findElement(By.name("middleName")).sendKeys("NA");
        driver.findElement(By.name("lastName")).sendKeys("NA");
        driver.findElement(By.xpath("//label[text() = 'Employee Id']/parent::div/parent::div//input")).click();
        for(int i=0;i<4;i++){
            driver.findElement(By.xpath("//label[text() = 'Employee Id']/parent::div/parent::div//input")).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(By.xpath("//label[text() = 'Employee Id']/parent::div/parent::div//input")).sendKeys("1951061");
        driver.findElement(By.xpath("//input[@type = 'checkbox']/following-sibling::span")).click();
        driver.findElement(By.xpath("//label[text() = 'Username']/parent::div/parent::div//input")).sendKeys("ace19");
        driver.findElement(By.xpath("//label[text() = 'Password']/parent::div/parent::div//input")).sendKeys("BlackP34rl#19");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/parent::div/parent::div//input")).sendKeys("BlackP34rl#19");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        WebElement toaster = driver.findElement(By.xpath("(//div[@id = 'oxd-toaster_1']//p)[2]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(toaster));
        System.out.println("Msg : " + toaster.getText());
    }
}
