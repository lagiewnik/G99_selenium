package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pagefactory.Guru99DateTimePicker;



public class TestDateTimePickerWithPagefactory {
		WebDriver driver;
		Guru99DateTimePicker objDateTimePicker;

		
		String driverPath = "C:\\selenium_web_driver\\chromedriver.exe";
		
		@BeforeTest
		
		public void setup(){
		
			System.setProperty("webdriver.chrome.driver", driverPath);
	        
	        driver = new ChromeDriver();
		    driver.get("http://demo.guru99.com/test/");
		
		}

	    /**

	     * This test case will test datatime picker on http://demo.guru99.com/test/
	     * @throws InterruptedException 

	     *

	     */
		@Test(priority=0)
		public void test_DateTimePicker() throws InterruptedException {
			 //Create 
			objDateTimePicker = new Guru99DateTimePicker(driver);
			
			objDateTimePicker.setDateAndTime("24022019", "1023PM");
			
			Thread.sleep(1000);
			
			objDateTimePicker.submitDateTimePicker();
			
			Thread.sleep(1000);
			System.out.println("Wynik: " + objDateTimePicker.getOutputText());
		}
		
		@AfterMethod
		public void closeBrowser() {
			driver.quit();
		}
}
