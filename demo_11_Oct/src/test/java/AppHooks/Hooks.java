package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    static WebDriver driver=null;
    @Before
    public void openBrowser() {
        System.out.println("Inside hooks class Before tag");
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public static WebDriver getWebDriver() {
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
        driver.quit();
    }


}
