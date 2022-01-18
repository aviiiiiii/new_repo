package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testClass1 extends base{
    WebDriver driver;
    private static Logger log= LogManager.getLogger(testClass1.class.getName());
    @BeforeTest
    public void setup() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

    @Test
    public void assertTest1(){
        Assert.assertEquals(landingPage.getSubtitle(),"FEATURED COURSES");
        log.info("Assertion passed");
    }
    @Test
    public void assertTest2(){
        Assert.assertTrue(landingPage.isSubtitlePresent());
    }



}
