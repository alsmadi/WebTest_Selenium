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

public class WebTestSelenium6 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "920e945a8e923c27218c2826c442339b";
    public static final String SECRET = "9c23867561a3319dbe19eed6c19cea44";
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
        this.driver.get("http://www.cornell.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "Cornell University");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.cornell.edu/");
    }

    //test tag name using class
    public void testTagNameByClass() {
        assertEquals(driver.findElement(By.className("marquee")).getTagName(), "div");
    }

    

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("main")).getTagName(), "div");
    }

    //test element attribute using id
    public void testAttribute() {
        assertEquals(driver.findElement(By.id("main")).getAttribute("alt"), null);
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("main")).isEnabled(), true);
    }

    //test if element seleted
    public void testIsSelected() {
        assertEquals(driver.findElement(By.id("main")).isSelected(), false);
    }

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("specific")).size(), 0);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(), 1);
    }
}
