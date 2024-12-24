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

public class T_MyInfoPDUITest extends SuiteBase {

    MyInfoPage myInfoPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    void lunch() throws IOException {
        startUp();
        lauchBrowser();
        loginPage = new LoginPage(driver);

        String msg = loginPage.login(param.getProperty("userName"),param.getProperty("password"));
        Assert.assertEquals(msg,"Login Successful");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.goTo("My Info");
        myInfoPage = new MyInfoPage(driver);

    }

    @Test(dataProvider = "testData")
    void T_myInfoPDUITest(int row, Hashtable<String,String> data) throws IOException {
        String evidencePath = getEvidencePath(this.getClass().getSimpleName(),data.get("Case_ID"));
        myInfoPage.setEvidencePath(evidencePath);
        Assert.assertEquals(myInfoPage.checkField(data.get("Field")),data.get("Status Expected"),"failed");
    }

    @AfterClass
    public void end(){
        tearDown();
    }

    @DataProvider
    public Object[][] testData() throws IOException {
        return getData(this);
    }
}
