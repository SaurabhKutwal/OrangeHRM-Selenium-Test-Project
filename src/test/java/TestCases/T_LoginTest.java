package TestCases;

import PageObjects.LoginPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T_LoginTest extends SuiteBase {

    LoginPage loginPage;
    @BeforeTest
    public void launch(){
        driver.get(param.getProperty("siteURL"));
        loginPage = new LoginPage(driver);
    }
    @Test(dataProvider = "testData")
    public void loginTest(String username, String password, String expectedMsg){
        String msg = loginPage.login(username,password);
        Assert.assertEquals(msg,expectedMsg);
    }

    @DataProvider
    public Object[][] testData(){
        return new Object[][]{
                {"temp","temp","Invalid credentials"},
                {"Admin","temp","Invalid credentials"},
                {"temp","admin123","Invalid credentials"},
                {"Admin","admin123","Login Successful"}
        };
    }

}
