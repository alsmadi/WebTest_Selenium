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

public class WebTestSelenium1 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "783b390605a30ff4c4648ab9a683b53b";
    public static final String SECRET = "518b9f12995e55dd4ab96820e0712bb6";
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
        this.driver.get("http://www.newhaven.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "University of New Haven : University of New Haven");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.newhaven.edu/");
    }

    //test tag name using class
    public void testTagNameByClass() {
        assertEquals(driver.findElement(By.className("content-query")).getTagName(), "div");
    }

    //test tag name using linkText
    public void testTagNameByLinkText() {
        assertEquals(driver.findElement(By.linkText("Future Students")).getTagName(), "a");
    }

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("p10500896")).getTagName(), "img");
    }

    //test element attribute using id
    public void testAttribute() {
        assertEquals(driver.findElement(By.id("p10500896")).getAttribute("alt"), "gil fried");
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("p10500896")).isEnabled(), true);
    }

    //test if element seleted
    public void testIsSelected() {
        assertEquals(driver.findElement(By.id("p8065520")).isSelected(), false);
    }

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("specific")).size(), 4);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(), 3);
    }
}
