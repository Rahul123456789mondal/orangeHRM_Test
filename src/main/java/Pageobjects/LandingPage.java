package Pageobjects;

import AbstactComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public HrmHomePage hrmHomePage;
    public LandingPage(WebDriver driver)
    {
        /* sending driver instances to superclass AbstractComponents */
        super(driver);
        //for local class variable driver life which is coming from - constructor initilization
        this.driver = driver;
        //Design- method
        PageFactory.initElements(driver, this);
    }

    //PageFactory ;driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
    @FindBy(xpath ="//input[@placeholder='Username']")
    WebElement username;
    By usernameW = By.xpath("//input[@placeholder='Username']");

     //PageFactory : driver.findElement(By.xpath("//input[@placeholder='Password']"))
    @FindBy(xpath ="//input[@placeholder='Password']")
    WebElement password;

   //PageFactory :  driver.findElement(By.xpath("//button[@type='submit']")).click();
    @FindBy(xpath ="//button[@type='submit']")
    WebElement submit;


    public void loginApp(String Username , String PassE)
    {
        waitForElementAppr(usernameW);
        System.out.println("Logging in...");
        username.sendKeys(Username);
        password.sendKeys(PassE);
        submit.click();
    }

}

/*public void goTo()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("in Goto");
    }*/