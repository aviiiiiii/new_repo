package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {

    WebDriver driver;

    @FindBy(id="buy-now-button") WebElement buyBtn;
    @FindBy(css = "h1.a-spacing-base") WebElement heading;

    public productPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void add_to_cart() throws InterruptedException {
        buyBtn.click();
        Thread.sleep(3000);
    }


    public void in_checkoutPage(){
        assert heading.isDisplayed();
    }

}
