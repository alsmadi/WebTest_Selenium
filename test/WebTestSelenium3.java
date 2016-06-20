/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import webtestselenium.*;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebTestSelenium3 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "e0968ed1e081a4e427389810d335e619";
    public static final String SECRET = "dc649e5a3bc25f4591750eef598d7f01";
    public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "11");
        capabilities.setCapability("platform", Platform.WINDOWS);
        capabilities.setCapability("name", "Testing Selenium 2");
       try{
        this.driver = new RemoteWebDriver(
                new URL(URL),
                capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       }
       catch(Exception ex){
           System.out.println("Driver problem");
       }
        this.driver.get("http://www.berkeley.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "Home | University of California, Berkeley");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.berkeley.edu/");
    }

    //test tag name using class
    public void testTagNameByClass() {
        assertEquals(driver.findElement(By.className("dropdown-toggle")).getTagName(), "a");
    }

    //test tag name using linkText
    public void testTagNameByLinkText() {
        assertEquals(driver.findElement(By.linkText("Alumni")).getTagName(), "a");
    }

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("content")).getTagName(), "div");
    }

}
