/// https://www.guru99.com/select-option-dropdown-selenium-webdriver.html

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG12_SelectDropDown {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			
    			String url = "http://demo.guru99.com/test/newtours/register.php";
    			driver.get(url);
    			    		     			
    		        Select drpCountry = new Select(driver.findElement(By.name("country")));
    		        drpCountry.selectByVisibleText("POLAND");	
    	//selecting item in multiple SELECT elements
    		    
    		        
    		    driver.navigate().to("http://jsbin.com/osebed/2");
    		    Select fruits = new Select(driver.findElement(By.id("fruits")));
    		    //now selecting BAnana and Apple
    		    fruits.selectByIndex(0);
    		    fruits.selectByValue("apple");
    		    
    		    
    		    driver.quit(); 
    			
       
    }

}