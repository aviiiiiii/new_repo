package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.security.sasl.SaslServer;
import java.awt.image.Kernel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class homePage {

    WebDriver driver;
    String prodName;

    @FindBy(id= "nav-logo-sprites") WebElement amazonLogo;
    @FindBy(id= "twotabsearchtextbox") WebElement searchBox;
    @FindBy(xpath = "//span[@cel_widget_id='MAIN-SEARCH_RESULTS-11']/div/div/div/div/div/div/div[1]") WebElement item1;
    @FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[1]/span/div/div/div[1]/div[2]/div[1]/div/div[1]/a/div/img")WebElement item2;
    @FindBy(id = "productTitle") WebElement prodTitle;





    public homePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void in_homePage() throws InterruptedException {
        Thread.sleep(1000);
        assert amazonLogo.isDisplayed();
    }

    public void enter_keyword(String key){
        searchBox.sendKeys(key);
        searchBox.sendKeys(Keys.ENTER);
    }

    public WebDriver select_item(){
        item2 .click();
        String mainWindow=driver.getWindowHandle();
        Set<String>handles=driver.getWindowHandles();
        Iterator<String>iterator=handles.iterator();
        while(iterator.hasNext()){
            String child=iterator.next();
            if(!mainWindow.equalsIgnoreCase(child))
                driver.switchTo().window(child);
        }
        System.out.println("INFO : "+prodTitle.getText()+" is selected");
        prodName=prodTitle.getText();
        return driver;
    }
    public String get_prodName(){
        return prodName;
    }




}
