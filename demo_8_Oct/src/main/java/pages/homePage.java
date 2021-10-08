package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.*;

public class homePage {

    WebDriver driver;

    @FindBy(className = "search-keyword") WebElement searchBox;
    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/div/div[3]/button") List<WebElement> addButton;
    @FindBy(xpath="//*[@id='root']/div/div[1]/div/div/div[3]/button/parent::div/parent::div/h4")List<WebElement>names;
    @FindBy(className = "cart-icon") WebElement cartBtn;
    @FindBy(css = "div.action-block button")WebElement checkoutBtn;




    public homePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enter_keyword(String key){
        searchBox.sendKeys(key);
        searchBox.sendKeys(Keys.ENTER);
    }

    public List<String> select_items() throws InterruptedException {
        List<String> items=new ArrayList<String>();
        Thread.sleep(2000);
        for(WebElement a : names){
            items.add(a.getText());
        }
        for(WebElement a : addButton){
            a.click();
        }

        return items;
    }

    public void checkout(){
        cartBtn.click();
        checkoutBtn.click();
    }




}
