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

//Kevin Steele

public class WebTestSelenium8 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "b079187c2bd01e59cb4e88f2e1405c4a";
    public static final String SECRET = "be36fbc1e23ebdbbd1b6490f5ad03217";
    public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "11");
        capabilities.setCapability("platform", Platform.MAC);
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
        this.driver.get("http://www.yale.edu");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "Yale University");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.yale.edu/");
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("header")).isEnabled(), true);
    }

    //test if element seleted
    public void testIsSelected() {
        assertEquals(driver.findElement(By.id("cboxTitle")).isSelected(), false);
    }

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("specific")).size(), 0);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(), 2);
    }
}
