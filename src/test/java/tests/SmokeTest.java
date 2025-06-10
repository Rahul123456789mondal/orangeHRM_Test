package tests;

import Pageobjects.LandingPage;
import org.testng.annotations.Test;
import testComponents.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void Smoke(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApp("Admin", "admin123");

    }

}
