package com.suite1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PokerTexas {
	WebDriver driver;
	final String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
    final String baseUrl = "https://pokertexas.net/";
    
    @BeforeTest
      public void launchBrowser() {
         DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         capabilities.setCapability("marionette", true);
         driver = new FirefoxDriver(capabilities);
         //driver.manage().window().maximize();
 		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 		 driver.navigate().to(baseUrl);
 	
      }
    @Test
    public void newsPage() {
    	driver.findElement(By.cssSelector("#menu-mainnav-1 > li:nth-child(1) > a:nth-child(1)")).click();
    }
	
    @Test
    public void czytelniaPage() {
    	driver.findElement(By.cssSelector(".sf-with-ul")).click();
    }
    
    @Test
    public void kontaktPage() {
    	driver.findElement(By.cssSelector("li.td-menu-item:nth-child(6) > a:nth-child(1)")).click();
    }
    
    @AfterClass
	public void quit() {
		driver.close();
	}
}
