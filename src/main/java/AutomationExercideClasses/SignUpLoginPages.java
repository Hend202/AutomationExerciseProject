package AutomationExercideClasses;

import Utilities.JsonFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpLoginPages {
    WebDriver driver;
    private String url= "https://www.automationexercise.com/signup";

    /// //Locators
    private String urllogin ="https://www.automationexercise.com/login";
    private By nameField = By.cssSelector("[data-qa='signup-name']");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signUPButton = By.xpath("//button[@data-qa='signup-button']");
    private By newUserSignUpText = By.xpath("//*[contains(text(), 'New User Signup!')]");





public SignUpLoginPages(WebDriver driver){
    this.driver=driver;
}








    /// /Action Method
    public SignUpLoginPages validateNewUserSignUpText() {
        driver.findElement(newUserSignUpText).isDisplayed();
        return this;
    }
    public SignUpLoginPages fillinSignupNameEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signUPButton).click();
        return this;
    }



}
