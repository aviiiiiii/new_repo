import io.cucumber.java.bs.I;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.session.CapabilityTransform;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class testClass {

    WebDriver driver;
    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        System.out.println(driver.getTitle());
        String[] items={"Cucumber","Carrot","Beans"};
        List<WebElement> Items=driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> btns=driver.findElements(By.xpath("//div[@class='product-action']/button"));
        System.out.println(Items.size());
        for(int i=0;i<Items.size();i++)
        {
            List<String> a= Arrays.asList(items);
            String[] name=Items.get(i).getText().split("-");
            String formattedName=name[0].trim();
            if(a.contains(formattedName)){
                System.out.println(formattedName);
                btns.get(i).click();
            }
        }
    }

    @Test
    public void test2(){
        String sam="For queries, reach out to letzgoyeah@gmail.com, Cheers";
        String sam2="Temporary password is 'Aviii' so use this";
        String[] splitted=sam.split(" ");
        List<String>splitList=Arrays.asList(splitted);
        System.out.println(splitList);
        String Email="a";
        for(int i=0;i<splitList.size();i++){
            if(splitList.get(i).contains("@")){
                Email = splitList.get(i);
            }
        }
        String[] splitted1=sam2.split("'");
        System.out.println(splitted1[1]);
        System.out.println(Email);

        String openInNewTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
        WebElement a=null;
        a.sendKeys(openInNewTab);

        List<String>windows=new ArrayList<String>(driver.getWindowHandles());
        for (String window : windows) {
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }
    }

    @Test
    public  void test3(){
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        driver=new ChromeDriver(options);
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.id("travel_date")).click();
        List<WebElement> dates=driver.findElements(By.className("day"));
        for(int i=0;i<driver.findElements(By.className("day")).size();i++){
            if(driver.findElements(By.className("day")).get(i).getText().equalsIgnoreCase("30")){
                System.out.println(driver.findElements(By.className("day")).get(i).getText());
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }
        driver.close();
    }


    @Test
    public void test4() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        Thread.sleep(3000);
        driver.close();


//        DesiredCapabilities ch=DesiredCapabilities.chrome();
//        ch.acceptInsecureCerts();
//        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
//        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
//        options.merge(ch);
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("abcd");


        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("I:\\SS\\ss.png"));

        String url=driver.findElement(By.tagName("a")).getAttribute("href");
        HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        System.out.println(conn.getResponseCode());

        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(false);

        softAssert.assertAll();

    }

    @Test
    public void test10(){
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        Actions action=new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath("//*[@id='gbwa']/div/a"))).click(driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div/c-wiz/div/div/ul[1]/li[2]/a/div[5]/span"))).build();

//        driver.findElement(By.xpath("//*[@id='gbwa']/div/a")).click();
//        driver.findElement(By.xpath("//*[text()='Search']")).click();
        WebElement a=driver.findElement(By.xpath("//*[@id='gbwa']/div/a"));
        action.click(a).build();

    }

    @Test
    public void test11(){
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> headers=driver.findElements(By.xpath("(//table[@id='product'])[2]//th"));
        Map map=new HashMap();
        int i=1;
        for(WebElement j : headers){
            map.put(j.getText(),i);
            i++;
        }
        System.out.println(map);
        System.out.println(map.get("Position"));
        List<WebElement> cityValues=driver.findElements(By.xpath("(//table[@id='product'])[2]//tbody//td["+map.get("City")+"]"));
        for(WebElement l : cityValues){
            System.out.println(l.getText());
        }
    }

    @Test
    public void test12() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//*[@id='opentab']")).click();
        ArrayList<String>windows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        Thread.sleep(7000);
        driver.close();
        driver.switchTo().window(windows.get(0));
        driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("INDIA");
    }

    @Test
    public void test13(){
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement element=driver.findElement(By.xpath("//div[@id='radio-btn-example']"));
        System.out.println(element.getLocation().getX());
        System.out.println(element.getLocation().getY());
        Dimension size=element.getSize();
        System.out.println(size.getWidth());
        System.out.println(size.getHeight());
        System.out.println(element.getSize());
    }

    @Test
    public void test14() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        WebElement from=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement to=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(from,to).build().perform();
    }

    @Test
    public void test15(){
        int a[][]={{2,4,5},{3,4,0},{1,2,9}};
        int max_col[]={-1,-1,-1};
        int min=99;
        int min_col=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                max_col[j]=Math.max(max_col[j],a[i][j]);
                if(min>a[i][j]){
                    min=a[i][j];
                    min_col=j;
                }
            }
        }
        System.out.println(max_col[min_col]);

    }

    @Test
    public void test16(){
        ArrayList<String> names=new ArrayList<>();
        names.add("Arun");
        names.add("Arvinth");
        names.add("Bala");
        names.add("Caron");
        names.add("Danny");
        int count=0;
//        for(int i=0;i<names.size();i++){
//            String name=names.get(i);
//            if(name.startsWith("A")){
//                count++;
//            }
//        }
////
//        long c=names.stream().filter(s -> s.startsWith("A")).count();
//        System.out.println(c);
//        System.out.println(count);
        System.out.println(names.stream().filter(s -> s.length() > 4).findFirst().get());
    }

    @Test
    public void test17() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Caron");
        names.add("Arun");
        names.add("Arvinth");
        names.add("Bala");
        names.add("Danny");

        names.stream().filter(s -> s.length() > 4).map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }

    @Test
    public void test18() {
        List<String> names=Stream.of("Aaa","Bbb","Ccc","Ddd","Eee").collect(Collectors.toList());
    }
    @Test
    public void test19(){
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Select pageSize=new Select(driver.findElement(By.xpath("//*[@id='page-menu']")));
        pageSize.selectByValue("20 ");
        List<WebElement>names1=driver.findElements(By.xpath("//tr/td[1]"));
        List<String>names=new ArrayList<>();
        names=names1.stream().map(s-> s.getText()).collect(Collectors.toList());
        System.out.println();names.sort(null);
        List<String>sorted=names.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
        driver.findElement(By.xpath("//*[text()='Veg/fruit name']")).click();
        List<String>new_names=new ArrayList<>();
        names1=driver.findElements(By.xpath("//tr/td[1]"));
        for(WebElement i : names1){
            new_names.add(i.getText());
        }
        System.out.println(new_names);
        Assert.assertTrue(sorted.equals(new_names));

    }

    @Test
    public void test20(){
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        List<WebElement>names1=driver.findElements(By.xpath("//tr/td[1]"));
        List<String>price=names1.stream().filter(s->s.getText().contains("Tomato")).map(s->getPrice(s)).collect(Collectors.toList());

        System.out.println(price);

    }

    private String getPrice(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    @Test
    public void test21() {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Select pageSize=new Select(driver.findElement(By.xpath("//*[@id='page-menu']")));
        pageSize.selectByValue("20");
        List<WebElement>names1=driver.findElements(By.xpath("//tr/td[1]"));
        List<String>all_items=names1.stream().map(s-> s.getText()).collect(Collectors.toList());
        driver.findElement(By.xpath("//*[@id='search-field']")).sendKeys("Rice");
        names1=driver.findElements(By.xpath("//tr/td[1]"));
        List<String>filtered_items=names1.stream().map(s-> s.getText()).collect(Collectors.toList());
        List<String>streamFilteredItems=all_items.stream().filter(s -> s.equalsIgnoreCase("Rice")).collect(Collectors.toList());
        System.out.println(streamFilteredItems);
        Assert.assertTrue(filtered_items.equals(streamFilteredItems));
    }

    @Test
    public void test22() {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("hello");
        searchBox.sendKeys(" ");

    }


}

