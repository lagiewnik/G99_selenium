// https://www.guru99.com/selenium-webtable.html

package newpackage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.tools.Tool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG21_Tooltip {


    public static void main(String[] args) throws InterruptedException, ParseException {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			
    			String url = "http://demo.guru99.com/test/social-icon.html";
    			  //Launching the site.				
                driver.get(url);			
                
                String exceptedTooltip = "Github";
                WebElement btnGit = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
                String tooltipGit = btnGit.getAttribute("title");
                
                //Assert the tooltip's value is as expected 		
                System.out.println("Actual Title of Tool Tip: "+tooltipGit);							
                if(tooltipGit.equals(exceptedTooltip)) {							
                    System.out.println("Test Case Passed");					
                }		
    	        
                
                /*
                 * More advanced tooltip with jQueryy
                 */
                String baseUrl = "http://demo.guru99.com/test/tooltip.html";
                String expectedTooltip = "What's new in 3.2";					
                driver.get(baseUrl);					
                		
                WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));							
                Actions builder = new Actions (driver);							

                builder.clickAndHold().moveToElement(download);					
                builder.moveToElement(download).build().perform(); 	
                
                WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));							
                String actualTooltip = toolTipElement.getText();			
                
                System.out.println("Actual Title of Tool Tip  "+actualTooltip);							
                if(actualTooltip.equals(expectedTooltip)) {							
                    System.out.println("Test Case Passed");					
                }		
   	   	        driver.quit();
    }

}