package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class formPage {

    WebDriver driver;
    JavascriptExecutor js;



    @FindBy(name = "name") WebElement nameBox;
    @FindBy(name = "email") WebElement emailBox;
    @FindBy(id = "exampleInputPassword1") WebElement passwordBox;
    @FindBy(id="exampleFormControlSelect1")WebElement gender;
    @FindBy(id="inlineRadio2")WebElement radioBtn;
    @FindBy(name = "bday")WebElement dobBox;
    @FindBy(xpath="//input[@type='submit']")WebElement submitBtn;
    @FindBy(css = "[class*='alert-success']")WebElement successMsg;

    public formPage(WebDriver driver){
        this.driver=driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }


    public void enter_name(String name){
        nameBox.sendKeys(name);
    }

    public void enter_email(String email){
        emailBox.sendKeys(email);
    }

    public void enter_password(String pwd){
        passwordBox.sendKeys(pwd);
    }

    public void select_gender(int option){
        Select s=new Select(gender);
        s.selectByIndex(option);
    }

    public void select_Employed(){
        radioBtn.click();
    }

    public void enter_dob(String dob){
        dobBox.sendKeys(dob);
    }

    public void submit(){
        submitBtn.click();
    }

    public  String getTexT(){
        js.executeScript("arguments[0].scrollIntoView();", successMsg);
        return successMsg.getText();
    }

}
