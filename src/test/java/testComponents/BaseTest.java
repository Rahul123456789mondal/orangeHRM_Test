package testComponents;

import Utility.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    public WebDriver driver;

    public WebDriver initilizeDriver() {

        // Get browser from system property or properties file
        String browserName = config.getProperty("browser");
        if (browserName !=  null){
            createDriver(browserName);
        }else {
            throw new RuntimeException("Please Pass The BrowserValue");
        }

        return driver;
    }

  @BeforeMethod(alwaysRun = true)
    public void launchApplication()
    {
        driver = initilizeDriver();
        driver.get(Objects.requireNonNull(config.getProperty("url")));
    }

  @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        System.out.println("Tearing down the code");
        if (driver != null) {
            driver = null; // Set to null to avoid memory leaks
        }
    }


    private void createDriver(String browserName) {

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


}

/*
*
* public WebDriver initializeDriver() throws IOException {

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
            System.out.println("Launching browser chrome...1");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            System.out.println("Launching browser firefox.");
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("Launching browser edge...3");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
*
*
*
*
*
*
*
*
* */
