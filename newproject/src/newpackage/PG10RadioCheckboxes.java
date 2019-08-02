/// https://www.guru99.com/checkbox-and-radio-button-webdriver.htmlhttps://www.guru99.com/checkbox-and-radio-button-webdriver.html

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
public class PG10RadioCheckboxes {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			
    			String url = "http://demo.guru99.com/test/radio.html";
    			driver.get(url);
    			
    		     			
    		        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
    		        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
    		        		
    		        //Radio Button1 is selected		
    		        radio1.click();			
    		        System.out.println("Radio Button Option 1 Selected");					
    		        		
    		        //Radio Button1 is de-selected and Radio Button2 is selected		
    		        radio2.click();			
    		        System.out.println("Radio Button Option 2 Selected");					
    		        		
    		        // Selecting CheckBox		
    		        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

    		        // This will Toggle the Check box 		
    		        option1.click();			

    		        // Check whether the Check box is toggled on 		
    		        if (option1.isSelected()) {					
    		            System.out.println("Checkbox is Toggled On");					

    		        } else {			
    		            System.out.println("Checkbox is Toggled Off");					
    		        }		
    		         
    		        		
    		        		
    		        //Selecting Checkbox and using isSelected Method		
    		        driver.get("http://demo.guru99.com/test/facebook.html");					
    		        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));							
    		        for (int i=0; i<25; i++) {											
    		            chkFBPersist.click (); 			
    		            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());							
    		        }	
    			
    			
    	       driver.quit(); 
    			
       
    }

}