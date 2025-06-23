package tests;

import Pageobjects.HrmHomePage;
import Pageobjects.LandingPage;
import Pageobjects.PimPage;
import org.testng.annotations.Test;
import testComponents.BaseTest;

public class FeatureTest extends BaseTest {

        @Test
        public void addEmployee() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        HrmHomePage hrmHomePage =  landingPage.loginApp("Admin", "admin123");
        PimPage pimpage = hrmHomePage.GotoPimPage();
        pimpage.addEmploye();
        //hrmHomePage.logout();


    }

}
