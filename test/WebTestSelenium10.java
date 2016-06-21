/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebTestSelenium10 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "1d76d5a44ef026d88ed0741734bc4b9a";
    public static final String SECRET = "8dcb5aac3cb47c8d6fbe79bce90c7a64";
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
        this.driver.get("http://www.minnesota.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "M State");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.minnesota.edu/");
    }

   

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("content")).getTagName(), "div");
    }

    //test element attribute using id
    public void testAttribute() {
        assertEquals(driver.findElement(By.id("content")).getAttribute("alt"), null);
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("content")).isEnabled(), true);
    }

    //test if element seleted
    

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("specific")).size(), 0);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(), 3);
    }
}
