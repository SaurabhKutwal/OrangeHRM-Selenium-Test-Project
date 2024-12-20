package UtilityObjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class PageUtility extends SuiteBase{

    public static void takeScreenshot(WebDriver driver,String path, String msg) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path + "//" + msg + ".png"));
    }
}
