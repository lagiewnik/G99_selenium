// https://www.guru99.com/selenium-webtable.html

package newpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.tools.Tool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG23_GetAllLinksOnWebPage {


    public static void main(String[] args) throws InterruptedException, ParseException {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    			
    			String baseUrl = "http://demo.guru99.com/test/newtours/";
    			  //Launching the site.				
                driver.get(baseUrl);	
                
                String underConsTitle = "Under Construction: Mercury Tours";
                List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
                String[] linkTexts = new String[linkElements.size()];							
        			int	i = 0;					

        			//extract the link texts of each link element		
        			for (WebElement e : linkElements) {							
        			linkTexts[i] = e.getText();							
        			i++;			
                }		

        			//test each link		
        			for (String t : linkTexts) {							
        			driver.findElement(By.linkText(t)).click();					
        			if (driver.getTitle().equals(underConsTitle)) {							
                        System.out.println("\"" + t + "\""								
                                + " is under construction.");			
                    } else {			
                        System.out.println("\"" + t + "\""								
                                + " is working.");			
                    }		
        			driver.navigate().back();			
                }		
                
                
   	   	        driver.quit();
    }

}