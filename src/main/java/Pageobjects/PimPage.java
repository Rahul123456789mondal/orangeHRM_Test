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
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and contains(., 'Add')]")
    WebElement addBtn;

    @FindBy(xpath ="//input[@placeholder='First Name']")
     WebElement firstName;

    @FindBy(xpath ="//input[@placeholder='First Name']")
    WebElement middleName;

    @FindBy(xpath ="//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath ="//label[normalize-space()='Employee Id']/following::div[1]/input")
    WebElement empID;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement sveBtn;

    //h6[normalize-space()='Personal Details']
    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    WebElement PersonalDetailsTxt;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    WebElement MaleCheckBox;

    @FindBy(xpath = "//div[contains(@class, 'oxd-form-actions')]//button[@type='submit']")
    WebElement saveBtn1st;

   public void addEmp(String FirstName, String LastName, String EmpID)
   {
       addBtn.click();
       waitForElementVisibility(firstName);
       firstName.sendKeys(FirstName);
       lastName.sendKeys(LastName);
       empID.sendKeys(EmpID);
       sveBtn.click();
       System.out.println("Employee added");
       /*clickElement(MaleCheckBox);
       clickElement(saveBtn1st);
       String txt = PersonalDetailsTxt.getText();
       System.out.println("add user 1st form was completed :"+txt);*/

   }
}
