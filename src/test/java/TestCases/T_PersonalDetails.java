package TestCases;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.MyInfoPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Hashtable;

import static UtilityObjects.ReadXLS.getData;
import static org.testng.TestRunner.PriorityWeight.priority;

public class T_PersonalDetails extends SuiteBase {
    MyInfoPage myInfoPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    void lunch() throws IOException {
        startUp();
        launchBrowser();
        loginPage = new LoginPage(driver);

        String msg = loginPage.login(param.getProperty("userName"),param.getProperty("password"));
        Assert.assertEquals(msg,"Login Successful");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.goTo("My Info");
        myInfoPage = new MyInfoPage(driver);
    }
    
    @Test(dataProvider = "testData")
    public void t_UpdatePersonalDetails(int row, Hashtable<String,String> data) throws IOException {
        String evidencePath = getEvidencePath(this.getClass().getSimpleName(),data.get("Case_ID"));
        myInfoPage.setEvidencePath(evidencePath);
        myInfoPage.updateField(data.get("Update Field"),data.get("Value"));
    }
    @AfterClass
    public void saveFunc() throws InterruptedException {
        String status = myInfoPage.saveForm();
        System.out.println(status);
        Assert.assertEquals(status,"Successfully Updated","Failed to Save");
    }
    @DataProvider
    public Object[][] testData() throws IOException {
        return getData(this);
    }
}
