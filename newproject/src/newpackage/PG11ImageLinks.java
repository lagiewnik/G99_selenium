/// https://www.guru99.com/click-on-image-in-selenium.html

package newpackage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG11ImageLinks {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			
    			String url = "https://www.facebook.com/login/identify?ctx=recover";
    			driver.get(url);
    			
    		     			
    		        WebElement imageLink = driver.findElement(By.cssSelector("a[title=\"PrzejdŸ na stronê g³ówn¹ Facebooka\"]"));
    		        
    		        String titlePageFirst = driver.getTitle();
    		        System.out.println("YOU are on page which title is: " + titlePageFirst);
    		        
    		        imageLink.click();
    		        
    		        //verify that we are now back on FB homepage
    		        String titlePageSecond = driver.getTitle();
    		        
    		        System.out.println("NOW YOU are on page which title is: " + titlePageSecond);
    		        
    		        if (titlePageSecond.equals("Facebook – zaloguj siê lub zarejestruj")) {
    		        	System.out.println("We are back at Facebook's homepage");
    		        }
    		        else {
    		        	System.out.println("We are NOT!!! at Facebook's homepage");
    		        }
    		        	
    		        
    			
    			
    	       driver.quit(); 
    			
       
    }

}