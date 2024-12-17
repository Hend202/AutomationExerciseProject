package Framework;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;


    @Step("Initialize new driver (Browser Type: {browserName}")
    public static WebDriver initiateDriver(String browserName, boolean maximize, Boolean headless){
        if (browserName.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOptions;
            if (Boolean.TRUE.equals(headless)) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
        } else if(browserName.equalsIgnoreCase("edge")){
            EdgeOptions edgeOptions;
            if (Boolean.TRUE.equals(headless)) {
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            } else {
                driver = new EdgeDriver();}

        }
        if(maximize){
            driver.manage().window().maximize();
        }
        return driver;

    }

}
// public static WebDriver initiateDriver(String browserName, boolean maximize){
//     if(browserName.equalsIgnoreCase("chrome")) {
//         driver = new ChromeDriver();
//     } else if (browserName.equalsIgnoreCase("firefox")) {
//        driver = new FirefoxDriver();
//     }
//     if(maximize) {
//         driver.manage().window().maximize();
//     }
//     return driver;
//     }










