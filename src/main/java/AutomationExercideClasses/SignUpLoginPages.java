package AutomationExercideClasses;

import Utilities.JsonFileManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static Framework.ElementActions.click;
import static Framework.ElementActions.sendKeys;

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
    @Step("Validate New User Signup Text")
    public SignUpLoginPages validateNewUserSignUpText() {
        driver.findElement(newUserSignUpText).isDisplayed();
        return this;
    }
    @Step("Fill in Signup name , Email")
    public SignUpLoginPages fillinSignupNameEmail(String name, String email) {
        sendKeys(driver,nameField,name);
        sendKeys(driver,emailField,email);
        click(driver,signUPButton);
        return this;
    }



}
