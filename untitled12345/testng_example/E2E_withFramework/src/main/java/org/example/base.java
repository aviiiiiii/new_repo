package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.landingPage;
import pageObjects.loginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {

    WebDriver driver;
    landingPage landingPage;
    loginPage loginPage;
    Properties prop;
    static int i=1;

    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\data.properties");
        prop.load(fis);
        String browser=prop.getProperty("browser");

        if(browser.contains("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            if(browser.contains("headless")){
                options.addArguments("headless");
            }
            driver=new ChromeDriver(options);
        }

        else if(browser.contains("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        landingPage=new landingPage(driver);
        loginPage=new loginPage(driver);

        return driver;
    }

    public String getScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destinationFile=System.getProperty("user.dir")+"\\target\\reports\\screenshots\\"+"Screenshot_"+i+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        i++;
        return destinationFile;
    }

}
