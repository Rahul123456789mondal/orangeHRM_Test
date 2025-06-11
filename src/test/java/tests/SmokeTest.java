package tests;

import Pageobjects.HrmHomePage;
import Pageobjects.LandingPage;
import org.testng.annotations.Test;
import testComponents.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void Smoke() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        HrmHomePage hrmHomePage =  landingPage.loginApp("Admin", "admin123");
        //NEED OPTIMIZATION OR PAGE LEVEL CHAINING
        HrmHomePage hrmHomePagee = new HrmHomePage(driver);
        hrmHomePagee.logout();

    }

}
