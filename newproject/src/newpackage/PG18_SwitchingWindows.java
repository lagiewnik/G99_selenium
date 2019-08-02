// https://www.guru99.com/upload-download-file-selenium-webdriver.html

package newpackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG18_SwitchingWindows {


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
    			
    			  //Launching the site.				
                driver.get("http://demo.guru99.com/popup.php");			
            driver.manage().window().maximize();		
                    		
    driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
            		
            String MainWindow=driver.getWindowHandle();		
            		
            // To handle all new opened window.				
                Set<String> s1=driver.getWindowHandles();		
            Iterator<String> i1=s1.iterator();		
            		
            while(i1.hasNext())			
            {		
                String ChildWindow=i1.next();		
                		
                if(!MainWindow.equalsIgnoreCase(ChildWindow))			
                {    		
                     
                        // Switching to Child window
                        driver.switchTo().window(ChildWindow);	                                                                                                           
                        driver.findElement(By.name("emailid"))
                        .sendKeys("gaurav.3n@gmail.com");                			
                        
                        driver.findElement(By.name("btnLogin")).click();			
                                     
    			// Closing the Child Window.
                            driver.close();		
                }		
            }		
            // Switching to Parent window i.e Main Window.
                driver.switchTo().window(MainWindow);		
    	        
    	        driver.quit();
    }

}