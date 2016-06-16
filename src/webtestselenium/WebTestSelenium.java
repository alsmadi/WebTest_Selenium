/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webtestselenium;

//import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTestSelenium  {
    private WebDriver driver;
    public static void main(String[] args) {
     WebTestSelenium w = new WebTestSelenium();
     try{
        w.setUp();
        
        w.testSimple();
     }
     catch(Exception ex){
         
     }
    }
    public void setUp() {
     /*   DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "11");
        capabilities.setCapability("platform", Platform.WINDOWS);
        capabilities.setCapability("name", "Testing Selenium 2"); */
     try{
       // this.driver = new  FirefoxDriver();
        WebDriver driver = new ChromeDriver();
            driver.get("www.newhaven.edu");
           
        }
     catch(Exception ex){
         
     }
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void testSimple()  {
        this.driver.get("www.newhaven.edu");
        System.out.println(this.driver.getTitle());
    }

    public void tearDown() throws Exception {
        this.driver.quit();
    }
}