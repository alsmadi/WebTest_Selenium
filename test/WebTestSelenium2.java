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

public class WebTestSelenium2 extends TestCase {

    private WebDriver driver;
    public static final String KEY = "ff0a024cb07e6736adc98f0c3c147976";
    public static final String SECRET = "fccb789d6548a6e31c0cd741a87de529";
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
        this.driver.get("http://www.caltech.edu/");
    }
 
    public void tearDown() throws Exception {
        this.driver.quit();
    }
    
//**********************************************************************************
//below are my test cases
    //test page title
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "Home | Caltech");
    }

    //test url
    public void testURL() {
        assertEquals(driver.getCurrentUrl(), "http://www.caltech.edu/");
    }

    //test tag name using class
    public void testTagNameByClass() {
        assertEquals(driver.findElement(By.className("responsive-container")).getTagName(), "div");
    }

    //test tag name using linkText
    public void testTagNameByLinkText() {
        assertEquals(driver.findElement(By.linkText("Learning the Language of the Laboratory")).getTagName(), "a");
    }

    //test tag name using id
    public void testTagNameById() {
        assertEquals(driver.findElement(By.id("block-system-main")).getTagName(), "div");
    }

    //test element attribute using link text
    public void testAttribute() {
        assertEquals(driver.findElement(By.linkText("Read more...")).getAttribute("class"), "read-more-link");
    }

    //test if element enabled
    public void testIsEnabled() {
        assertEquals(driver.findElement(By.id("discover-more")).isEnabled(), true);
    }

    

    //test the number of elements with the given class name
    public void testElementsByClassName() {
        assertEquals(driver.findElements(By.className("frontpage-teaser")).size(), 14);

    }

    //test the number of elements with the given tag name
    public void testElementsByTagName() {
        assertEquals(driver.findElements(By.tagName("input")).size(),4);
    }
}
