// https://www.guru99.com/selenium-webtable.html

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
public class PG19_Table {


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
                driver.get("file:///D:/KURSY/TESTOWANIE/G99_selenium/G99_selenium/newproject/src/html/table.html");			
                String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
                System.out.println(innerText);
                
                String innerText2 = driver.findElement(
                		By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText(); 		
                        System.out.println(innerText2); 
                        
                        
                        
/*
 * Finding table using attributes
 */
                String baseUrl = "http://demo.guru99.com/test/newtours/";
                driver.get(baseUrl);
                String innerText3 = driver.findElement(By
                		.xpath("//table[@width=\"270\"]/tbody/tr[4]/td"))
                		.getText(); 		
                	System.out.println(innerText3);
                
            	innerText = driver.findElement(By
            			.xpath("//table/tbody/tr/td[2]"
            			+ "//table/tbody/tr[4]/td/"
            			+ "table/tbody/tr/td[2]/"
            			+ "table/tbody/tr[2]/td[1]/"
            			+ "table[2]/tbody/tr[3]/td[2]/font"))
            			.getText(); 		
            	System.out.println(innerText); 
   	   	        driver.quit();
    }

}