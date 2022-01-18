package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage {

    WebDriver driver;

    @FindBy(id = "nav-cart-count-container") WebElement cartBtn;
    @FindBy(name = "proceedToRetailCheckout") WebElement buyBtn;
    @FindBy(partialLinkText = "Deliver to this address") WebElement addressBtn;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/div/div/div/div[4]/div/div/div/div/div[2]") WebElement upi;
    @FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/div/div/div/div[4]/div/div/div/div/div[2]/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div[1]/input")WebElement upi_name;
    @FindBy(name = "ppw-widgetEvent:ValidateUpiIdEvent")WebElement verifyBtn;
    @FindBy(name="ppw-widgetEvent:SetPaymentPlanSelectContinueEvent")WebElement continueBtn;

    public checkoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void go_to_cart(){
        cartBtn.click();
    }

    public void proceed_to_buy(){
        buyBtn.click();
    }

    public void select_address(){
        addressBtn.click();
    }

    public void select_upi(String upiId) throws InterruptedException {
        Thread.sleep(15000);
        System.out.println(driver.getTitle());
        upi.click();
        Thread.sleep(3000);
        upi_name.sendKeys(upiId);
        verifyBtn.click();
        Thread.sleep(5000);
        continueBtn.click();
        Thread.sleep(3000);
    }

}
