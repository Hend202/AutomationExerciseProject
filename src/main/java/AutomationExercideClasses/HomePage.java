package AutomationExercideClasses;
import Framework.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static Framework.ElementActions.getCurrentUrl;
import static Framework.ElementActions.getTitle;


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
        Assert.assertEquals(getTitle(driver), "Automation Exercise");
        Assert.assertEquals(getCurrentUrl(driver), "https://automationexercise.com/");
        return this;
    }


}
