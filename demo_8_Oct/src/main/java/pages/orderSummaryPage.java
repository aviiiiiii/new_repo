package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class orderSummaryPage {


    WebDriver driver;

    @FindBy(className = "promoCode") WebElement promoBox;
    @FindBy(xpath = "//tbody/tr/td[2]") List<WebElement> itemList;
    @FindBy(className = "promoBtn")WebElement applyBtn;
    @FindBy(xpath = "//div[@class='products']/div/button")WebElement placeOrderBtn;
    @FindBy(css = "span.discountAmt")WebElement finalPrice;




    public orderSummaryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void in_orderSummaryPage(){
        assert promoBox.isDisplayed();
    }


    public List<String> verify_items(){
        List<String> item=new ArrayList<String>();
        for(WebElement a :itemList){
            item.add(a.getText());
        }
        return item;
    }

    public void apply_promoCode(String code) throws InterruptedException {
        promoBox.sendKeys(code);
        applyBtn.click();
        Thread.sleep(7000);
    }


    public String get_finalPrice(){
        return finalPrice.getText();
    }

    public void place_order(){
        placeOrderBtn.click();
    }



}
