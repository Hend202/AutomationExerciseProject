package AutomationExercideClasses;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePage {
    WebDriver driver;
    private String url="https://www.automationexercise.com/";

    /// /////////////// Locators


public HomePage(WebDriver driver){
    this.driver = driver;
}





    /// /////Action Method
    @Step("Validate Existence on Automation Exercise website")
    public  HomePage validateExistenceOnAutomationWebsite() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        return this;
    }

}
