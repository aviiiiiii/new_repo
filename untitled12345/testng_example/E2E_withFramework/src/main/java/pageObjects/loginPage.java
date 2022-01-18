package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    By txt_email=By.xpath("//input[@type='email']");
    By txt_password=By.xpath("//input[@type='password']");
    By btn_login=By.xpath("//input[@value='Log In']");

    //methods
    public void enter_email(String email){
        driver.findElement(txt_email).sendKeys(email);
    }
    public void enter_password(String password){
        driver.findElement(txt_password).sendKeys(password);
    }
    public void click_login(){
        driver.findElement(btn_login).click();
    }

}
