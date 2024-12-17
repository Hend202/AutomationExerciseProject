package Framework;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {
    private static final int Default_Waiting_Time = 10;

    @Step("Click on Element with Locator {elementLocator}")
    public static void click(WebDriver driver, By elementLocator){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));


        String elementName = driver.findElement(elementLocator).getAccessibleName();
        driver.findElement(elementLocator).click();

        System.out.println("Click on element " + elementLocator + " " + elementName);


    }
    @Step("Type text into element located by: {elementLocator}")
    public static void sendKeys(WebDriver driver, By elementLocator, String text) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Default_Waiting_Time));
        elementWaiting(driver, wait, elementLocator);
        WebElement element = driver.findElement(elementLocator);
        element.clear(); // Clear any existing text
        element.sendKeys(text);
        System.out.println("Send keys to located element: " + text);
    }

    @Step("Select Dropdown Option by Visible Text: {elementLocator}")
    public static void selectDropdownByValue(WebDriver driver, By elementLocator, String value) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Default_Waiting_Time));
        elementWaiting(driver, wait, elementLocator);
        Select dropdown = new Select(driver.findElement(elementLocator));
        dropdown.selectByValue(value);
        System.out.println("Selected dropdown option: " + value);
    }
    @Step("Get Text from Element located by: {elementLocator}")
    public static String getText(WebDriver driver, By elementLocator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Default_Waiting_Time));
        elementWaiting(driver, wait, elementLocator);
        return driver.findElement(elementLocator).getText();
    }

    @Step("Get the title of the current webpage")
    public static String getTitle(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Default_Waiting_Time));
        return driver.getTitle();
    }
    @Step("Get the Url of the current webpage")
    public static String getCurrentUrl(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Default_Waiting_Time));
        return driver.getCurrentUrl();
    }



    private static void elementWaiting(WebDriver driver, Wait<WebDriver> wait, By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

}
