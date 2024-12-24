package TestCases;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.MyInfoPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T_MyInfoPDUITest extends SuiteBase {

    MyInfoPage myInfoPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeTest
    void lunch(){
        lauchBrowser();
        loginPage = new LoginPage(driver);
        loginPage.tempLogin(param.getProperty("userName"),param.getProperty("password"));

        dashboardPage = new DashboardPage(driver);
        dashboardPage.goTo("My Info");
        myInfoPage = new MyInfoPage(driver);
    }

    @Test(dataProvider = "testData")
    void myInfoPDUITest(String field, String expected){
        Assert.assertEquals(myInfoPage.checkField(field),expected,"failed");
    }

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                {"FirstName","Enable"},
                {"MiddleName","Disable"},
                {"LastName","Enable"},
                {"EmployeeId","Disable"},
                {"OtherId","Enable"},
                {"Driver License Number","Disable"},
                {"License Expiry Date","Enable"},
                {"Nationality","Enable"},
                {"Marital Status","Enable"},
                {"Date Of Birth","Disable"},
                {"Male Checkbox","Enable"},
                {"Female Checkbox","Enable"}
        };
    }


}
