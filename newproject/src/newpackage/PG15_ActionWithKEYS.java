/// https://www.guru99.com/keyboard-mouse-events-files-webdriver.html

package newpackage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG15_ActionWithKEYS {


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
    			
    			String url = "http://www.fb.com/";
    			driver.get(url);
    			
    			WebElement txtUsername = driver.findElement(By.id("email"));

    			Actions builder = new Actions(driver);
    			Action seriesOfActions = builder
    				.moveToElement(txtUsername)
    				.click()
    				.keyDown(txtUsername, Keys.SHIFT)
    				.sendKeys(txtUsername, "hello")
    				.keyUp(txtUsername, Keys.SHIFT)
    				.doubleClick(txtUsername)
    				.contextClick()
    				.build();
    				
    			seriesOfActions.perform() ;
       
    }

}