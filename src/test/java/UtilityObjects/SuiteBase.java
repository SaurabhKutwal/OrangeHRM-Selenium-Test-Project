package UtilityObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class SuiteBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public Properties param;

    public void startUp() throws IOException {
        initDriver();
        initProperties();
    }

    void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Driver Initialization Successfully");
    }

    void initProperties() throws IOException {
        param = new Properties();
        param.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//properties//test.properties")));
        System.out.println("Properties file loaded");
    }

    public String getEvidencePath(String testClass,String caseId){
        new File(System.getProperty("user.dir") + "//Outputs//Evidences//" + testClass).mkdir();
        String time = new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date());
        String path = System.getProperty("user.dir") + "//Outputs//Evidences//" + testClass + "//" + caseId + " " + time;
        new File(path).mkdir();
        return path;
    }
    public void lauchBrowser(){
        driver.get(param.getProperty("siteURL"));
        System.out.println("Browser Launched");
    }

    public void refresh(){
        driver.navigate().refresh();
    }


    public void tearDown(){
        driver.quit();
    }
}
