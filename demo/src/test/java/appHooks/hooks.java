package appHooks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.*;

public class hooks {

    static WebDriver driver=null;
    @Before
    public void openBrowser() {
        System.out.println("Inside hooks class Before tag");
//        System.setProperty("webdriver.gecko.driver", "I:\\geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public static WebDriver getWebDriver() {
        System.out.println("Inside getWebDriver");
        return driver;
    }

    @AfterStep
    public void addScreenShot(Scenario scenario){
        String scenarioName=scenario.getName();
        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png",scenarioName);
    }

    @After(order = 0)
    public void closeBrowser() {
        System.out.println("Inside hooks class After tag");
        driver.close();
    }

}
