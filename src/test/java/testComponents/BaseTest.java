package testComponents;

import Pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingpage;


    public WebDriver initializeDriver() throws IOException {
        //Property class
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalData.properties");
        prop.load(fis);
       String browserName = prop.getProperty("browser");

        // For invoking through maven cmd terminal
        //String browserName = System.getProperty("browser") != null?  System.getProperty("browser") : prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.out.println("Launching browser...1");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            System.out.println("Launching browser..2.");
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("Launching browser...3");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

  @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException
    {
        driver = initializeDriver();
        landingpage = new LandingPage(driver);
        landingpage.goTo();
        return landingpage;
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }


}
