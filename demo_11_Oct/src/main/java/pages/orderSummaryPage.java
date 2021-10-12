package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderSummaryPage {
    WebDriver driver;

    @FindBy(css = "strong.asin-title")WebElement prodTitle;
    @FindBy(xpath = "//tbody/tr[6]/td[2]")WebElement prodPrice;
    @FindBy(xpath = "//img[@alt='Place Your Order - Amazon.in Checkout']")WebElement summaryPageLogo;

    public orderSummaryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void in_orderSummaryPage(){
        assert summaryPageLogo.isDisplayed();
    }

    public void print_details(){
        System.out.println("INFO : product Title : "+prodTitle.getText());
        System.out.println("INFO : product Price : "+prodPrice.getText());
    }


}
