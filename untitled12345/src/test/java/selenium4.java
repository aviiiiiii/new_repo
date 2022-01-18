import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class selenium4 {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement ans=driver.findElement(with(By.tagName("label")).toLeftOf(By.cssSelector("[for='inlineRadio1']")));
        System.out.println(ans.getText());
//.toRightOf(By.cssSelector("[type='radio']"))
    }

    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        https://rahulshettyacademy.com/#/index
        driver.switchTo().newWindow(WindowType.WINDOW);
        ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.get("https://rahulshettyacademy.com/#/index");
        String title=driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/section[2]/div[1]/div[2]/div[1]/div/div[2]/div[1]/h2/a")).getText();
        driver.switchTo().window(windows.get(0));
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(title);
    }

    @Test
    public void test3() throws IOException {
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys("Aviii");
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:\\Users\\Avinash\\Desktop\\SS\\one.png"));

    }
    @Test
    public void test4(){
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(name.getRect().height);
        System.out.println(name.getRect().width);
        System.out.println(name.getRect().x);
        System.out.println(name.getRect().getX());
        System.out.println(name.getRect().y);
        System.out.println(name.getRect().getY());
        System.out.println(name.getRect().getHeight());
        System.out.println(name.getRect().getDimension().getHeight());
    }


    @Test
    public void test5(){
        int k=10;
        for(int i=0;i<4;i++){
            for(int j=0;j<=i;j++){
                System.out.print(k+" ");
                k--;
            }
            System.out.println("");
        }
    }

    @Test
    public void test6(){
        int k=1;
        for(int i=4;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println("");
        }
    }

    @Test
    public void test7(){
        int k=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<=i;j++){
                System.out.print(k*3+" ");
                k++;
            }
            System.out.println("");
        }
    }


}
