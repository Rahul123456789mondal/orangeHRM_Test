package AbstactComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {

        //Life of local driver instance variable driver was coming from child class constuctor by super kryword and assign by this keyword
        this.driver = driver;
    }

    // Explicit wait class Taking Params only findBy Webelement
    public void waitForElementAppr(By findBy)
    {
        // wating for the element to be located
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
}
