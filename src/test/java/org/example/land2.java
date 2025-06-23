package org.example;

import Pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class land2 {

    public String BaseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


}

/*    @Test
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BaseUrl);
        LandingPage landingpage = new LandingPage(driver);
        //landingpage.goTo();
//        Thread.sleep(3000);
        //landingpage.loginApp("admin","admin123");
//        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();*/
//    }
    /*@Test
    public void GotoE()
    {
        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
*/