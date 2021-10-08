package AppHooks;

import StepDefinitions.addingSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;

public class hooks {

    static WebDriver driver=addingSteps.getDriver();
//
//    @Before
//    public void openBrowser() {
//        System.out.println("Inside hooks class Before tag");
//        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//
//    }
//
//    public static WebDriver getWebDriver() {
//        System.out.println("Inside getWebDriver");
//        return driver;
//    }
//
//
//    @After
//    public void closeBrowser() {
//        System.out.println("Inside hooks class After tag");
//        driver.close();
//    }


    @AfterStep
    public void getScreenShot(Scenario scenario){
        String scenarioName=scenario.getName();
        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png",scenarioName);
    }
}
