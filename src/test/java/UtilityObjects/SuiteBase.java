package UtilityObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class SuiteBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public Properties param;
    @BeforeSuite
    public void startUp() throws IOException {
        initDriver();
        initProperties();
    }

    void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    void initProperties() throws IOException {
        param = new Properties();
        param.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//properties//test.properties")));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
