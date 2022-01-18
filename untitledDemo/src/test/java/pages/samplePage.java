package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class samplePage {

    private final WebDriver driver;
    public samplePage(WebDriver driver){
        this.driver=driver;
    }
    public void enter_details(String name, String email) throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys(email);
        Thread.sleep(1000);

    }
    public void click_submitButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@value='Submit']")).click();
        Thread.sleep(1000);

    }
    public void is_formSubmitted(){
        if(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed()){
            System.out.println("From Submitted Successfully");
        }
    }
}
