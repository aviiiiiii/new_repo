package org.example;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testClass2 extends base{
    WebDriver driver;
    @Test(dataProvider = "getData")
    public void loginTest(String email, String password) throws IOException, InterruptedException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
        landingPage.goToLogin();
        loginPage.enter_email(email);
        loginPage.enter_password(password);
        Thread.sleep(2000);
        loginPage.click_login();
        driver.close();
    }


    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[2][2];
        data[0][0]="user1@gmail.com";
        data[0][1]="user1";
        data[1][0]="user2@gmail.com";
        data[1][1]="user2";
        return data;

    }
}
