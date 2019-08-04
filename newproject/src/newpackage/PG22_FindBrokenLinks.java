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
public class PG22_FindBrokenLinks {


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
    			
    			String baseUrl = "https://pokertexas.net";
    			  //Launching the site.				
                driver.get(baseUrl);			
                String homePage = "https://pokertexas.net";
                String url = "";
                HttpsURLConnection huc = null;
                int respCode = 200;
                
                driver.manage().window().maximize();
                
                driver.get(homePage);
                
                List<WebElement> links = driver.findElements(By.tagName("a"));
                
                Iterator<WebElement> it = links.iterator();
                
                while(it.hasNext()){
                    
                    url = it.next().getAttribute("href");
                    
                    System.out.println(url);
                
                    if(url == null || url.isEmpty()){
        System.out.println("URL is either not configured for anchor tag or it is empty");
                        continue;
                    }
                    
                    if(!url.startsWith(homePage)){
                        System.out.println("URL belongs to another domain, skipping it.");
                        continue;
                    }
                    
                    try {
                        huc = (HttpsURLConnection)(new URL(url).openConnection());
                        
                        huc.setRequestMethod("HEAD");
                        
                        huc.connect();
                        
                        respCode = huc.getResponseCode();
                        
                        if(respCode >= 400){
                            System.out.println(url+" is a broken link");
                        }
                        else{
                            System.out.println(url+" is a valid link");
                        }
                            
                    } catch (MalformedURLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
                
   	   	        driver.quit();
    }

}