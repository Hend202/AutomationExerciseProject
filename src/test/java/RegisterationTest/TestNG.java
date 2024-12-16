package RegisterationTest;

import AutomationExercideClasses.*;
import Utilities.JsonFileManager;
import Utilities.PropertiesReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Framework.DriverFactory.initiateDriver;

public class TestNG {
    private JsonFileManager jsonFileManager;
    WebDriver driver;
    @BeforeMethod
    public void beforeclass() {
        driver = initiateDriver(System.getProperty("browserName"),true);
        jsonFileManager = new JsonFileManager("src/test/resources/TestDataJsonFile/TestData.json");
        navigationToUrl();

    }

    @Test(description = "SignupProcess")
    @Description("Automation Exercise Website Signup")
    @Severity(SeverityLevel.CRITICAL)
    public void SignupTestCase() {
        new HomePage(driver)
                .validateExistenceOnAutomationWebsite();
        new MenuHeader(driver)
                .clickSignUpButton();
        new SignUpLoginPages(driver)
                .validateNewUserSignUpText()
                .fillinSignupNameEmail(jsonFileManager.getTestData("name"), jsonFileManager.getTestData("email"));
        //signUpForm.validateAccountInfoText();
        new SignUpForm(driver)
                .fillAccountInfo("Hen2", "2", "3", "2000")
                .selectCheckboxNewsLetter()
                .selectCheckboxrOffers()
                .fillAddressInfo("Henda", "ALiou", "Giza", "11 Delhy", "70 D", "India", "Delhy", "Delhy", "27394", "9086574")
                .clickOnCreateAccountButton()
                .validateAccountCreatedText()
                .pressContinueAfterSignUp();
        new MenuHeader(driver)
                .deleteAccount();
        new AccountDeletedPage(driver)
                .validateOAccountDeletedText()
                .pressContinueAfterDeleteAccount();
    }

    @AfterMethod
    public void afterclass() {
        driver.quit();
    }

    /// ///////Action Method

    private void navigationToUrl() {
        driver.navigate().to("https://automationexercise.com/");
    }
    @BeforeSuite
    public void beforsuit(){
        PropertiesReader.loadProperties();
    }
}
