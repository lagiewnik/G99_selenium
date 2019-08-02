/// https://www.guru99.com/locate-by-link-text-partial-link-text.html

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
public class PG13_Links {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			
    			String url = "file:\\d:\\KURSY\\TESTOWANIE\\G99_selenium\\G99_selenium\\newproject\\src\\html\\links.html";
    			driver.get(url);
    			
    			//finding link by  Exact Text Match: By.linkText() 
    			 driver.findElement(By.linkText("click here")).click();					
    		     System.out.println("title of page is: " + driver.getTitle());			 			
    		    
    		     //get another page
    		     driver.get("file:\\\\d:\\\\KURSY\\\\TESTOWANIE\\\\G99_selenium\\\\G99_selenium\\\\newproject\\\\src\\\\html\\\\links2.html");
    		     
    		     //Accessing links using Partial Text Match: By.partialLinkText()
    		     driver.findElement(By.partialLinkText("here")).click();					
    		     System.out.println("Title of page is: " + driver.getTitle());	   	
    		        
    		     driver.get("http://demo.guru99.com/test/newtours/");
    		     String theLinkText = driver.findElement(By					
    		                .partialLinkText("egis"))			
    		                .getText();		
    		        System.out.println(theLinkText);					
    		        theLinkText = driver.findElement(By					
    		                .partialLinkText("EGIS"))			
    		                .getText();		
    		        System.out.println(theLinkText);
    			
    	       driver.quit(); 
    			
       
    }

}