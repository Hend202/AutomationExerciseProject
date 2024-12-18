package AutomationExercideClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static Framework.ElementActions.click;
import static Framework.ElementActions.getText;

public class AccountDeletedPage {
    WebDriver driver;
    private String url="https://www.automationexercise.com/delete_account";

    /// //Locators
    private By deletedAccountText = By.xpath("//b[text()='Account Deleted!']");
    private By continueButtonAfterDelete = By.xpath("//a[@data-qa='continue-button']");






    public  AccountDeletedPage(WebDriver driver){
        this.driver=driver;
    }






    /// /Action Method

    @Step("Validate Account Deleted Text")
    public AccountDeletedPage validateOAccountDeletedText(){

        Assert.assertEquals(getText(driver,deletedAccountText),"ACCOUNT DELETED!");
        return this;
    }
    @Step("Click Continue Button After Deleting the account")
    public AccountDeletedPage pressContinueAfterDeleteAccount() {
        click(driver,continueButtonAfterDelete);
        return this;
    }




}
