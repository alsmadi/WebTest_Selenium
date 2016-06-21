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

public class WebTestSelenium9 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "da830b05a68a9057f0cefbd6fd157f39";
    public static final String SECRET = "e673253bdb2e574891156866d68a8427";
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
        this.driver.get("http://www.columbia.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "Columbia University in the City of New York");
        System.out.println(driver.getTitle());
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.columbia.edu/");
    }

    //test tag name using class
    public void testTagNameByClass() {
        assertEquals(driver.findElement(By.className("content-query")).getTagName(), "div");
    }

    //test tag name using linkText
    public void testTagNameByLinkText() {
        assertEquals(driver.findElement(By.linkText("RESEARCH")).getTagName(), "a");
    }

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("omega-media-query-dummy")).getTagName(), "img");
    }

    //test element attribute using id
    public void testAttribute() {
        assertEquals(driver.findElement(By.id("omega-media-query-dummy")).getAttribute("alt"), "gil fried");
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("omega-media-query-dummy")).isEnabled(), true);
    }

    //test if element seleted
    public void testIsSelected() {
        assertEquals(driver.findElement(By.id("omega-media-query-dummy")).isSelected(), false);
    }

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("specific")).size(), 0);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(), 5);
    }
}
