package TestCases;

import PageObjects.LoginPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Hashtable;

import static UtilityObjects.ReadXLS.getData;

public class T_LoginTest extends SuiteBase {

    LoginPage loginPage;

    @BeforeClass
    public void launch() throws IOException {
        startUp();
        launchBrowser();
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void refreshSite(){
        refresh();
    }
    @Test(dataProvider = "testData")
    public void T_loginTest(int row,Hashtable<String,String> data) throws IOException {
        String evidencePath = getEvidencePath(this.getClass().getSimpleName(),data.get("Case_ID"));
        loginPage.setEvidencePath(evidencePath);

        String msg = loginPage.login(data.get("Username"),data.get("Password"));
        Assert.assertEquals(msg,data.get("Expected"));
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
