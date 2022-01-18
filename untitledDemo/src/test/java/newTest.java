import com.google.common.collect.ImmutableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;
import org.openqa.selenium.devtools.v96.fetch.Fetch;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ConnectionType;
import org.openqa.selenium.devtools.v96.network.model.ErrorReason;
import org.openqa.selenium.devtools.v96.network.model.Request;
import org.openqa.selenium.devtools.v96.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v96.network.model.Response;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.security.sasl.SaslServer;
import java.io.File;
import java.net.URI;
import java.util.*;
import java.util.function.Predicate;

public class newTest {
    //Log4j
    private static Logger log= LogManager.getLogger(newTest.class.getName());
    WebDriver driver;
    @Test
    public void test2() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
    }

    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
    }
    @Test
    public void test4() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        String downloadPath=System.getProperty("user.dir")+"//downloads";
        ChromeOptions options=new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs",chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://airconvertpdftojpg.com/");
        driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("C://Users//Avinash//Downloads//one.pdf");
        Thread.sleep(10000);
        WebDriverWait wait=new WebDriverWait(driver,60);
        By btn_convert=By.xpath("//button[text()='Convert Now!']");
        wait.until(ExpectedConditions.elementToBeClickable(btn_convert));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(btn_convert));
        driver.findElement(btn_convert).click();
        By btn_download=By.xpath("//a[text()='Download']");
        wait.until(ExpectedConditions.elementToBeClickable(btn_download));
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(btn_download));
        driver.findElement(btn_download).click();
            File f=new File(downloadPath+"/1.jpg");
            if(!(f.exists())){
                System.out.println("File does not exists");

            }else {
                System.out.println("File exists");
                f.delete(); //for continuous testing
            }

    }

    @Test
    public void test5() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        //Note : browser switches to normal mode after executing the last step

        //if no custom Selenium command is present
        Map<String,Object> deviceMetrics=new HashMap();
        deviceMetrics.put("width",600);
        deviceMetrics.put("height",1000);
        deviceMetrics.put("deviceScaleFactor",50);
        deviceMetrics.put("mobile",true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
    }

    @Test
    public void test6() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        //localization testing
        Map<String,Object> geo=new HashMap();
        geo.put("latitude",40);
        geo.put("longitude",3);
        geo.put("accuracy",1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride",geo);
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Netflix");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER );
    }

    @Test
    public void test7() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        //Extracting network response
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.responseReceived(), response -> {
            Response res=response.getResponse();
            System.out.println(res);
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            if (res.getStatus().toString().startsWith("4")){
                //Logging only error
                System.out.println(res.getUrl()+" is failing with status code : "+res.getStatus());
            }
        });
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req=request.getRequest();
            System.out.println(req);
            System.out.println(req.getUrl());
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }

    @Test
    public void test8() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        //Mocking network request(Fetch domain in CDP)
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            if (request.getRequest().getUrl().contains("shetty")) {
                String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(mockedUrl);
                devTools.send(Fetch.continueRequest(
                        request.getRequestId(),
                        Optional.of(mockedUrl),
                        Optional.of(request.getRequest().getMethod()),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
            } else {
                devTools.send(Fetch.continueRequest(
                        request.getRequestId(),
                        Optional.of(request.getRequest().getUrl()),
                        Optional.of(request.getRequest().getMethod()),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
            }
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
    }

    @Test
    public void test9() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        //Network failed request(Fetch domain in CDP)
        List<RequestPattern> pattern= Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty()));
        devTools.send(Fetch.enable(Optional.of(pattern),Optional.empty()));
        devTools.addListener(Fetch.requestPaused(),request -> {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.ACCESSDENIED));
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void test10() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        //Blocking unwanted Network request(Network domain in CDP)
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        System.out.println(driver.findElement(By.cssSelector("p")).getText());

    }

    @Test
    public void test11() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commands to CDP Methods
        //https://chromedevtools.github.io/devtools-protocol/
        //Emulate network speed(Network domain in CDP)
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                3000,
                20000,
                10000,
                Optional.of(ConnectionType.ETHERNET)
        ));
        devTools.addListener(Network.loadingFailed(),loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
    }

    @Test
    public void test12() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //predicate
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
    }

    @Test
    public void test13() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //logging JS error
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
        LogEntries logEntries=driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry>logEntryList=logEntries.getAll();
        for(LogEntry e : logEntryList){
            System.out.println(e.getMessage());
        }
    }
}
