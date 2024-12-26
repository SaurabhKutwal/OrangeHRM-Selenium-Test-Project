package UtilityObjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class PageUtility extends SuiteBase{

    public static void takeScreenshot(WebDriver driver,String path, String name) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path + "//" + name + ".png"));
    }

    public static void takeScreenshotOfWebEle(WebElement element, String path, String name) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path + "//" + name + ".png"));
    }
}
