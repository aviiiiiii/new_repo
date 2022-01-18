package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingPage {

    public WebDriver driver;

    public landingPage(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    By lnk_signIn =By.xpath("//span[text()='Login']/parent::a");
    By txt_title=By.xpath("//section/div/div/h2");

    //methods
    public void goToLogin(){
        driver.findElement(lnk_signIn).click();
    }
    public String getSubtitle(){
        return driver.findElement(txt_title).getText();
    }
    public boolean isSubtitlePresent(){
        return driver.findElement(txt_title).isDisplayed();
    }
}
