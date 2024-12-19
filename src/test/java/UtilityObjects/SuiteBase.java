package UtilityObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class SuiteBase {

    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeSuite
    public void startUp(){
        initDriver();
    }

    void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
