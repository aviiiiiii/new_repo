package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkoutPage {

    WebDriver driver;

    @FindBy(id = "nav-cart-count-container") WebElement cartBtn;
    @FindBy(name = "proceedToRetailCheckout") WebElement buybtn;
    @FindBy(partialLinkText = "Deliver to this address") WebElement addressBtn;
    @FindBy(name = "ppw-bankSelection_dropdown")WebElement bankDropdown;
    @FindBy(xpath = "//input[@id='pp-MuS32i-102']")WebElement netBanking;

    public checkoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void go_to_cart(){
        cartBtn.click();
    }

    public void proceed_to_buy(){
        buybtn.click();
    }

    public void select_address(){
        addressBtn.click();
    }

    public void select_bank(String bank) throws InterruptedException {
        Thread.sleep(15000);
        System.out.println(driver.getTitle());
        System.out.println(netBanking.isDisplayed());
        netBanking.click();
        Select s=new Select(bankDropdown);
        s.selectByVisibleText("ICICI Bank");
    }

}
