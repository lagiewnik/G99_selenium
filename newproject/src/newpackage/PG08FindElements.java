///https://www.guru99.com/find-element-selenium.html

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
public class PG08FindElements {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			
    			driver.get("http://demo.guru99.com/test/ajax.html");
    			
    			List<WebElement> elements = driver.findElements(By.tagName("div"));
    			System.out.println("Number of div: "+ elements.size());
    			
    			for (int i=0; i<elements.size(); i++) {
    				System.out.println("Div id: " + elements.get(i).getAttribute("id"));
					System.out.println("Div content: " + elements.get(i).getText());
					System.out.println("================================================");
    			}
    			
    	        driver.quit(); 
    			
       
    }

}