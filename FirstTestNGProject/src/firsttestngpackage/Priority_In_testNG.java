//https://www.guru99.com/test-case-priority-testng.html
package firsttestngpackage;
import org.openqa.selenium.By;			
import org.openqa.selenium.WebDriver;			
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;			

public class Priority_In_testNG {		
	 WebDriver driver;	
	 final String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
	 
	 	

	    // Method 1: Open Brower say Firefox			
	    @Test(priority=1)		
	    public void a_openBrowser() {				
	    	System.setProperty("webdriver.gecko.driver", driverPath);
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver(capabilities);			
	    }		

	    // Method 2: Launch Google.com			
	    @Test(priority = 2 )
	    public void b_launchGoogle() {				
	        driver.get("http://www.google.pl");						
	    }		
        
	    // Method 3: Perform a search using "Facebook"			
	    @Test(priority = 3)	
	    public void c_peformSeachAndClick1stLink() throws Exception {				
	        driver.findElement(By.xpath(".//*[@title='Szukaj']")).sendKeys("holdem texas");
	        Thread.sleep(3000);	
	        driver.findElement(By.name("btnK")).click();
	    }		

	    // Method 4: Verify Google search page title.			
	    @Test (priority = 4)	
	    public void d_FaceBookPageTitleVerification() throws Exception {				
	        //driver.findElement(By.name("btnK")).click();						
	        Thread.sleep(3000);		
	        Assert.assertEquals(driver.getTitle().contains("holdem texas - Szukaj w Google"), true);				
	    }		
	}		
