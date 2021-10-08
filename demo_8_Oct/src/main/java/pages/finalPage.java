package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class finalPage {

    WebDriver driver;

    @FindBy(css = "input.chkAgree") WebElement checkBox;
    @FindBy(css="select")WebElement countryDropdown;
    @FindBy(css="button")WebElement proceedBtn;
    @FindBy(xpath="//div[@class='products']/div/span")WebElement confirm_msg;


    public finalPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void user_in_finalPage(){
        assert checkBox.isDisplayed();
    }

    public void select_country(String country){
        Select s = new Select(countryDropdown);
        s.selectByValue(country);
    }

    public void agree_to_TandC(){
        checkBox.click();
    }

    public void confirm_order(){
        proceedBtn.click();
    }
    //your order has been placed successfully
    public void checkMsg(String msg) throws InterruptedException {
        Thread.sleep(2000);
        assert confirm_msg.getText().contains(msg);
    }
}
