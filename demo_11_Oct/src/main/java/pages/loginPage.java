package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;

public class loginPage {

    WebDriver driver;

    @FindBy(name = "email") WebElement PhoneNo;
    @FindBy(id = "continue") WebElement continueBtn;
    @FindBy(name = "password") WebElement password;
    @FindBy(id = "signInSubmit") WebElement signInBtn;
    @FindBy(id= "nav-logo-sprites") WebElement amazonLogo;


    public loginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enter_phoneNo(String Ph){
        PhoneNo.sendKeys(Ph);
        continueBtn.click();
    }

    public void enter_pwd(String pwd){
        password.sendKeys(pwd);
        signInBtn.click();
    }

    public void in_homePage() throws InterruptedException {
        Thread.sleep(1000);
        assert amazonLogo.isDisplayed();
    }

}
