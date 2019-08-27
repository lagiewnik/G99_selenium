package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pagefactory.Guru99HomePage;
import pagefactory.Guru99Login;


public class Test99GuruLoginWithPageFactory {
		WebDriver driver;
		Guru99Login objLogin;

		Guru99HomePage objHomePage;
		String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
		
		@BeforeTest
		
		public void setup(){
		
			System.setProperty("webdriver.gecko.driver", driverPath);
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver(capabilities);
		    driver.get("http://demo.guru99.com/V4/");
		
		}

	    /**

	     * This test case will login in http://demo.guru99.com/V4/

	     * Verify login page title as guru99 bank

	     * Login to application

	     * Verify the home page using Dashboard message

	     */
		 @Test(priority=0)
		public void test_Home_Page_Appear_Correct() {
			 //Create Login Page object
			objLogin = new Guru99Login(driver);
			
			//Verify login Paage Title
			String loginPageTitle = objLogin.getLoginTitle();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
			
			//login to aplication
			objLogin.loginToGuru99("mgr123","mgr!23");
			
			//go to next page
			objHomePage = new Guru99HomePage(driver);
			
			// verify home page
			Assert.assertTrue(objHomePage.getHomePageDAshboardUserName().toLowerCase().contains("manger id : mgr123"));
			
		}
		
		@AfterMethod
		public void closeBrowser() {
			driver.quit();
		}
}
