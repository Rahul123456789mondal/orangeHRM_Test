package Pageobjects;

import AbstactComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage extends AbstractComponent {

    WebDriver driver;
    public PimPage(WebDriver driver)
    {
        /* sending driver instances to superclass AbstractComponents */
        super(driver);
        //for local class variable driver life which is coming from - constructor initilization
        this.driver = driver;
        //Design- method
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//button[normalize-space()='Add']")
    WebElement addBtn;

    @FindBy(xpath ="//input[@placeholder='First Name']")
     WebElement firstName;

    @FindBy(xpath ="//input[@placeholder='First Name']")
    WebElement middleName;

    @FindBy(xpath ="//input[@placeholder='Last Name']")
    WebElement lastName;

//    @FindBy(xpath ="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
//    WebElement empID;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement sveBtn;

    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Save'])[1]")
    WebElement preDetSveBtn;

   public void addEmploye()
   {
       addBtn.click();
       waitForElementVisibility(firstName);
       firstName.sendKeys("xyz");
       middleName.sendKeys("Best");
       lastName.sendKeys("CCB");
//       String eid = empID.getText();
//       System.out.println(eid);
//       sveBtn.click(); -- not working need js executor scroll
//       waitForElementVisibility(preDetSveBtn);
 //       preDetSveBtn.click();
        System.out.println("Employee added");

   }




}
