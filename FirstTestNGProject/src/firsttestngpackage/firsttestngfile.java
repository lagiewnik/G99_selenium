package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class firsttestngfile {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
    public WebDriver driver; 
     
     @BeforeTest
      public void launchBrowser() {
    	 System.setProperty("webdriver.gecko.driver", driverPath);
         DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         capabilities.setCapability("marionette", true);
         driver = new FirefoxDriver(capabilities);
      }
      @Test
      public void verifyHomepageTitle() {
    	  driver.get(baseUrl);
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
     }
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}

