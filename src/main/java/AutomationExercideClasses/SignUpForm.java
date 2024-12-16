package AutomationExercideClasses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static Framework.ElementActions.click;
import static Framework.ElementActions.selectDropdownByValue;

public class SignUpForm {
    WebDriver driver;
    /// //////Locator
    private By newUserSignUpText = By.xpath("//*[contains(text(), 'New User Signup!')]");
    private By accountInfoText = By.xpath("//b[text()='Enter Account Information']");
    private By idGender = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By selectDay = By.id("days");
    private By selectMonths = By.id("months");
    private By selectingyears = By.id("years");
    private By selectNewsLetter = By.id("newsletter");
    private By selectRecieveOffers = By.id("optin");
    private By first_name = By.id("first_name");
    private By last_name = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By selectCountry = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@type='submit']");
    private By continueButtonAfterSignUp = By.xpath("//a[@data-qa='continue-button']");
    private By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");





  public SignUpForm(WebDriver driver){
        this.driver = driver;
    }







    /// //////////Action Method

    @Step("Fill in the account information with valid data ")
    public SignUpForm fillAccountInfo(String password, String Day, String month, String year) {
        click(driver,idGender);
        //fill the form Account Info
        driver.findElement(passwordField).sendKeys(password);
        selectDropdownByValue(driver,selectDay,Day);
        selectDropdownByValue(driver,selectMonths,month);
        selectDropdownByValue(driver,selectingyears,year);
        return this;

    }
    @Step("Click Check box News Letter")
    public SignUpForm selectCheckboxNewsLetter() {
        click(driver,selectNewsLetter);
        return this;
    }
    @Step("Click Check box offers")
    public SignUpForm selectCheckboxrOffers() {
        click(driver,selectRecieveOffers);
        return this;
    }
    @Step("Fill information for address")
    public SignUpForm fillAddressInfo(String firstName, String lastName, String Company, String firstaddress, String secondaddress, String country, String State, String City, String ZipCode, String MobileNumber) {
        driver.findElement(first_name).sendKeys(firstName);
        driver.findElement(last_name).sendKeys(lastName);
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(firstaddress);
        driver.findElement(address2).sendKeys(secondaddress);
        new Select(driver.findElement(selectCountry)).selectByValue(country);
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(ZipCode);
        driver.findElement(mobileNumber).sendKeys(MobileNumber);
        return this;
    }
    @Step("Click on create account button after filling the data")
    public SignUpForm clickOnCreateAccountButton() {
        click(driver,createAccountButton);
        return this;
    }
    @Step("Press continue button after signup")
    public SignUpForm pressContinueAfterSignUp() {
        click(driver,continueButtonAfterSignUp);
        return this;
    }
    @Step("Validate Account Created  Text")
    public SignUpForm validateAccountCreatedText() {
        Assert.assertEquals(driver.findElement(accountCreatedText).getText(), "ACCOUNT CREATED!");
        return this;
    }

}
