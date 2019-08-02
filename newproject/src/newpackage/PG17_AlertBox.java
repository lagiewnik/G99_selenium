// https://www.guru99.com/upload-download-file-selenium-webdriver.html

package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG17_AlertBox {


    public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			
    			 // Alert Message handling
        		
    	        driver.get("http://demo.guru99.com/test/delete_customer.php");			
    	                            		
    	     	      	
    	        driver.findElement(By.name("cusid")).sendKeys("53920");					
    	        driver.findElement(By.name("submit")).submit();			
    	        		
    	        // Switching to Alert        
    	        Alert alert = driver.switchTo().alert();		
    	        		
    	        // Capturing alert message.    
    	        String alertMessage= driver.switchTo().alert().getText();		
    	        		
    	        // Displaying alert message		
    	        System.out.println(alertMessage);	
    	        Thread.sleep(5000);
    	        		
    	        // Accepting alert		
    	        alert.accept();		
    	        
    	        driver.quit();
    }

}