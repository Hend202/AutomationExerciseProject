package Framework;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {
    private static final int DEFAULT_WAITING_TIME = 10;

    @Step("Click on Element with Locator {elementLocator}")
    public static void click(WebDriver driver, By elementLocator){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));


        String elementName = driver.findElement(elementLocator).getAccessibleName();
        driver.findElement(elementLocator).click();

        System.out.println("Clicking on element " + elementLocator + " " + elementName);


    }
    @Step("Select Dropdown Option by Visible Text: {elementLocator}")
    public static void selectDropdownByValue(WebDriver driver, By elementLocator, String value) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME));
        elementWaiting(driver, wait, elementLocator);
        Select dropdown = new Select(driver.findElement(elementLocator));
        dropdown.selectByValue(value);
        System.out.println("Selected dropdown option: " + value);
    }
    private static void elementWaiting(WebDriver driver, Wait<WebDriver> wait, By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}
