package TestCases;

import PageObjects.LoginPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import static UtilityObjects.ReadXLS.getData;

public class T_LoginTest extends SuiteBase {

    LoginPage loginPage;
    @BeforeTest
    public void launch() throws IOException {
        lauchBrowser();
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void refreshSite(){
        refresh();
    }
    @Test(dataProvider = "testData")
    public void loginTest(int row,Hashtable<String,String> data) throws IOException {
        String evidencePath = prepEvidence(this.getClass().getSimpleName(),data.get("Case_ID"));
        loginPage.setEvidencePath(evidencePath);

        String msg = loginPage.login(data.get("Case_ID"),data.get("Username"),data.get("Password"));
        Assert.assertEquals(msg,data.get("Expected"));
    }

    @DataProvider
    public Object[][] testData() throws IOException {
        return getData(this);
    }
}
