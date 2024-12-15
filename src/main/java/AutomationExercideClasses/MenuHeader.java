package AutomationExercideClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuHeader {
    WebDriver driver;

    /// /////Locators
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By signupLoginButton = By.linkText("Signup / Login");


    public MenuHeader(WebDriver driver){
        this.driver=driver;
    }






    /// ///Action Mtehod
    public MenuHeader deleteAccount(){
        driver.findElement(deleteAccountButton).click();
        return this;
    }
    public MenuHeader clickSignUpButton() {
        driver.findElement(signupLoginButton).click();
        return this;
    }
}
