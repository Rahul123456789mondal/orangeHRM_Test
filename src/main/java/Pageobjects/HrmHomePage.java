package Pageobjects;

import AbstactComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HrmHomePage extends AbstractComponent {

    WebDriver driver;
    public HrmHomePage(WebDriver driver)
    {
        /* sending driver instances to superclass AbstractComponents */
        super(driver);
        //for local class variable driver life which is coming from - constructor initilization
        this.driver = driver;
        //Design- method
        PageFactory.initElements(driver, this);
        System.out.println("HrmHomePage loaded");
    }


    //PageFactory ;driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
     WebElement ProfileIcon;
    @FindBy(xpath = "//ul[@role='menu']")
    WebElement menu2;
    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement logoutBtn;
    @FindBy(xpath="//span[normalize-space()='PIM']")
     WebElement PIMNavBtn;
    @FindBy(xpath="//h6[normalize-space()='PIM']")
    WebElement PIMheader;
    By ProfileIcon2 = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By Menu = By.xpath("//ul[@role='menu']");


    public void logout() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ProfileIcon2));
        ProfileIcon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Menu));
        logoutBtn.click();
    }

    public PimPage GotoPimPage()
    {
        waitForElementVisibility(PIMNavBtn);
        PIMNavBtn.click();
        waitForElementVisibility(PIMheader);
        String headerText = PIMheader.getText();
        System.out.println("I am in the page"+" "+ headerText);
        return new PimPage(driver);
    }

}
