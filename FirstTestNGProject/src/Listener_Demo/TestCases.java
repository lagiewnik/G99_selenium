package Listener_Demo;		

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;		
import org.testng.annotations.Test;		

//@Listeners(Listener_Demo.ListenerTest.class)	

public class TestCases {				
	WebDriver driver;
	final String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
    final String baseUrl = "http://demo.guru99.com/V4/";
    
    @BeforeTest
      public void launchBrowser() {
         DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         capabilities.setCapability("marionette", true);
         driver = new FirefoxDriver(capabilities);
         //driver.manage().window().maximize();
 		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }				

// Test to pass as to verify listeners .		
@Test		
public void Login()				
{		
    driver.get(baseUrl);					
    driver.findElement(By.name("uid")).sendKeys("mngr34926");							
    driver.findElement(By.name("password")).sendKeys("amUpenu");							
    driver.findElement(By.name("btnLogin")).click();					
}		

// Forcefully failed this test as to verify listener.		
@Test		
public void TestToFail()				
{		
    System.out.println("This method to test fail");					
    Assert.assertTrue(false);			
}		
}