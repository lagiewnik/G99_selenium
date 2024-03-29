//https://www.guru99.com/sessions-parallel-run-and-dependency-in-selenium.html
package firsttestngpackage;

import java.sql.DriverPropertyInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class MultipleSession_In_testNG {
	
	public final String driverPath = "C:\\selenium_web_driver\\chromedriver.exe";
    @Test    
    public void executSessionOne(){
            //First session of WebDriver
    	Reporter.log("First session of WebDriver");
        System.setProperty("webdriver.chrome.driver", driverPath);
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            Reporter.log("Goto guru99 site");
            driver.get("http://demo.guru99.com/V4/");
            //find user name text box and fill it
            Reporter.log("find user name text box and fill it");
            driver.findElement(By.name("uid")).sendKeys("Driver 1");
            
        }
        
    @Test    
        public void executeSessionTwo(){
            //Second session of WebDriver
    	Reporter.log("second session of WebDriver");
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        Reporter.log("Goto guru99 site");
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        Reporter.log("find user name text box and fill it");
        driver.findElement(By.name("uid")).sendKeys("Driver 2");
        
        }
        
    @Test    
        public void executSessionThree(){
            //Third session of WebDriver
    	Reporter.log("third session of WebDriver");
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        Reporter.log("Goto guru99 site");
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        Reporter.log("find user name text box and fill it");
        driver.findElement(By.name("uid")).sendKeys("Driver 3");
        
        }        
}