package AutomationExercideClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

    public AccountDeletedPage validateOAccountDeletedText(){

        Assert.assertEquals(driver.findElement(deletedAccountText).getText(),"ACCOUNT DELETED!");
        return this;
    }
    public AccountDeletedPage pressContinueAfterDeleteAccount() {
        driver.findElement(continueButtonAfterDelete).click();
        return this;
    }




}
