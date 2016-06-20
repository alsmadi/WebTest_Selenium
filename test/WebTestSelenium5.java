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

public class WebTestSelenium5 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "67b8f6653a77926028ba716d42d83966";
    public static final String SECRET = "7ea5f4db0e0ac2295e5f91beb6702452";
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
        this.driver.get("http://web.mit.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "MIT - Massachusetts Institute of Technology");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://web.mit.edu/");
    }

    //test tag name using class
    public void testTagNameByClass() {
        assertEquals(driver.findElement(By.className("front")).getTagName(), "body");
    }

    //test tag name using linkText
    public void testTagNameByLinkText() {
        assertEquals(driver.findElement(By.linkText("about")).getTagName(), "a");
    }

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("footer")).getTagName(), "div");
    }

    //test element attribute using id
    public void testAttribute() {
        assertEquals(driver.findElement(By.id("header")).getAttribute("alt"), null);
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("google")).isEnabled(), true);
    }

    //test if element seleted
    public void testIsSelected() {
        assertEquals(driver.findElement(By.id("google")).isSelected(), true);
    }

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("menu")).size(), 11);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(), 5);
    }
}
