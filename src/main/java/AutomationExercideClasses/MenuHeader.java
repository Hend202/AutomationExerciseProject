package AutomationExercideClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Framework.ElementActions.click;

public class MenuHeader {
    WebDriver driver;

    /// /////Locators
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By signupLoginButton = By.linkText("Signup / Login");


    public MenuHeader(WebDriver driver){
        this.driver=driver;
    }






    /// ///Action Mtehod
    @Step(" Delete the account")
    public MenuHeader deleteAccount(){
        click(driver,deleteAccountButton);
        return this;
    }
    @Step("Click Signup button")
    public MenuHeader clickSignUpButton() {
        click(driver,signupLoginButton);
        return this;
    }
}
