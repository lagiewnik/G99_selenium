/// https://www.guru99.com/accessing-forms-in-webdriver.html

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
public class PG09TextBoxSubmitBtn {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			
    			String url = "http://demo.guru99.com/test/login.html";
    			driver.get(url);
    			
    			WebElement email = driver.findElement(By.id("email"));
    			WebElement password  = driver.findElement(By.name("passwd"));
    			
    			email.sendKeys("mariano@italiano.pl");
    			password.sendKeys("adsuf834324wrf");
    			
    			//deleting test boxes
    			email.clear();
    			password.clear();
    			
    			email.sendKeys("mariano@italiano.pl");
    			password.sendKeys("adsuf834324wrf");
    			
    			//find button:
    			WebElement BtnSubmit = driver.findElement(By.id("SubmitLogin"));
    			//click on submit button
    			//BtnSubmit.click();
    			
    			/*
    			 * Submit buttons are used to submit the entire form to the server. We can either use the click () method on the web element like a normal button as we have done above or use the submit () method on any web element in the form or on the submit button itself. 
    			 */
    			email.submit();
    			
    			
    	       // driver.quit(); 
    			
       
    }

}