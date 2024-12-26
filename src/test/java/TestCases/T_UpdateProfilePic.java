package TestCases;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.MyInfoPage;
import UtilityObjects.SuiteBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class T_UpdateProfilePic extends SuiteBase {

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

    @Test
    public void t_UpdateProfilePic() throws InterruptedException, IOException {
        String evidencePath = getEvidencePath(this.getClass().getSimpleName(),"Case_018");
        myInfoPage.setEvidencePath(evidencePath);
        Assert.assertEquals(myInfoPage.uploadPic(),"Successfully Updated","Failed to Save");
    }

    @AfterClass
    public void end(){
        tearDown();
    }
}
