package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pages.GoogleSearchParameters;



public class TestGoogleSearch {
		WebDriver driver;
		GoogleSearchParameters objSearch;

		
		String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
		String textSearch = "poker texas";
		String author = "ziom";
		@BeforeTest
		
		public void setup(){
		
			System.setProperty("webdriver.gecko.driver", driverPath);
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver(capabilities);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get("https://google.pl");
		
		}

	    /**

	     * This test case will login in http://demo.guru99.com/V4/

	     * Verify login page title as guru99 bank

	     * Login to application

	     * Verify the home page using Dashboard message
	     * @throws InterruptedException 

	     */
		 @Test(priority=0)
		public void test_SugestionGoogle() throws InterruptedException {
			 //Create Login Page object
			objSearch = new GoogleSearchParameters(driver);
			
			//put text in search  field
			objSearch.setSearchText(textSearch);
			/*
			List<WebElement> lstGoogle = driver.findElement(By.xpath("//ul[@role='listbox']"))
					.findElements(By.xpath("//li[@role='presentation']"));
						for (int i = 0; i < lstGoogle.size(); i++) {
							System.out.println(lstGoogle.get(i).getText());
						}
			*/
			//get first sugestion of search:
			Thread.sleep(500);
			String firstSugestionText = objSearch.getFirstSugestion();
			
			// verify that first sugestion is equal search text:
			System.out.println("Welcome ->"+author+" Your search key is->"+textSearch);
            System.out.println("Thread will sleep now");
            
            Thread.sleep(3000);
            System.out.println("First sugestion Value in Google Search Box = "+ firstSugestionText +" ::: Value given by input = "+textSearch);
			Assert.assertTrue(firstSugestionText.toLowerCase().contains(textSearch));
			
		}
		
		@AfterMethod(enabled=true)
		public void closeBrowser() {
			driver.quit();
		}
}
