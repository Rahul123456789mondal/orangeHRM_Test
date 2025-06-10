package tests;

import Pageobjects.HrmHomePage;
import Pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.io.IOException;

public class SmokeTest extends BaseTest {
    @Test
    public void Smoke() throws InterruptedException, IOException {

        LandingPage landingpage  = launchApplication();
        HrmHomePage hrmhome = landingpage.loginApp("admin","admin123");

    }

}
