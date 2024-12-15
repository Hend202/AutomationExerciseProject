package GoogleAutomate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
public class GoogleAutomate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {    FileUtils.copyFile(file,new File ("./ScreenShot_Folder/Test1_Login.png"));} catch (IOException e) {    throw new RuntimeException(e);}

        WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
        System.out.println("home page visibility is :"+signupLoginButton.isDisplayed());
        signupLoginButton.click();
        WebElement NewUser = driver.findElement(By.xpath("//*[contains(text(), 'New User Signup!')]"))  ;
        System.out.println("New user is visible :"+NewUser.isDisplayed());
        WebElement NameTextField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
        NameTextField.sendKeys("Henda");
        WebElement EmailTextfield = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        EmailTextfield.sendKeys("Henda4@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender2")).click();
        WebElement PasswordTextfield = driver.findElement(By.id("password"));
        PasswordTextfield.sendKeys("Henda123");
        Select YearList = new Select(driver.findElement(By.id("years")));
        YearList.selectByVisibleText("2001");
        Select MonthList = new Select(driver.findElement(By.id("months")));
        MonthList.selectByValue("2");
        Select DayList = new Select(driver.findElement(By.id("days")));
        DayList.selectByValue("5");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        WebElement AddresssFirstNamefield = driver.findElement(By.id("first_name"));
        AddresssFirstNamefield.sendKeys("Hanoda");
        WebElement AddresssLastNamefield = driver.findElement(By.id("last_name"));
        AddresssLastNamefield.sendKeys("Ali");
        WebElement AddresssCompanyfield = driver.findElement(By.id("company"));
        AddresssCompanyfield.sendKeys("Amazon");
        WebElement AddressRequiredfield = driver.findElement(By.id("address1"));
        AddressRequiredfield.sendKeys("11 Arezon America");
        WebElement AddressSecondfield = driver.findElement(By.name("address2"));
        AddressSecondfield.sendKeys("102 Arezona  South America");
        Select CountryList = new Select(driver.findElement(By.id("country")));
        CountryList.selectByVisibleText("Australia");
        WebElement AddressStatefield = driver.findElement(By.id("state"));
        AddressStatefield.sendKeys("Victoria");
        WebElement AddressCityfield = driver.findElement(By.id("city"));
        AddressCityfield.sendKeys("Victoria1");
        WebElement AddressZipCodefield = driver.findElement(By.id("zipcode"));
        AddressZipCodefield.sendKeys("77901");
        WebElement AddressMobileNumberfield = driver.findElement(By.id("mobile_number"));
        AddressMobileNumberfield.sendKeys("29384098");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.quit();






    }
}
