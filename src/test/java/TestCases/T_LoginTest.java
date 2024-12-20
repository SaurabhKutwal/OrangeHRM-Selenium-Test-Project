package TestCases;

import PageObjects.LoginPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class T_LoginTest extends SuiteBase {

    LoginPage loginPage;
    @BeforeTest
    public void launch(){
        lauchBrowser();
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void refreshSite(){
        refresh();
    }
    @Test(dataProvider = "testData")
    public void loginTest(String caseId,String username, String password, String expectedMsg) throws IOException {
        String evidencePath = prepEvidence(this.getClass().getSimpleName(),caseId);
        loginPage.setEvidencePath(evidencePath);

        String msg = loginPage.login(caseId,username,password);
        Assert.assertEquals(msg,expectedMsg);
    }

    @DataProvider
    public Object[][] testData(){
        return new Object[][]{
                {"Case_001","temp","temp","Invalid credentials"},
                {"Case_002","Admin","temp","Invalid credentials"},
                {"Case_003","temp","admin123","Invalid credentials"},
                {"Case_004","Admin","admin123","Login Successful"}
        };
    }
}
