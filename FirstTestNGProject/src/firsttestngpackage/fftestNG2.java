package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class fftestNG2 {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "C:\\selenium_web_driver\\geckodriver.exe";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
    
     @BeforeTest
      public void launchBrowser() {
    	 System.setProperty("webdriver.gecko.driver", driverPath);
         DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         capabilities.setCapability("marionette", true);
         driver = new FirefoxDriver(capabilities);
         driver.get(baseUrl);
      }
      
     @BeforeMethod
     public void verifyHomepageTitle() {
         String expectedTitle = "Welcome: Mercury Tours";
         String actualTitle = driver.getTitle();
         Assert.assertEquals(actualTitle, expectedTitle);
     }
         @Test(priority = 0)
     public void register(){
         driver.findElement(By.linkText("REGISTER")).click() ;
         expected = "Register: Mercury Tours";
         actual = driver.getTitle();
         Assert.assertEquals(actual, expected);
     }
         @Test(priority = 1)
     public void support() {
           driver.findElement(By.linkText("SUPPORT")).click() ;
           expected = "Under Construction: Mercury Tours";
           actual = driver.getTitle();
           Assert.assertEquals(actual, expected);
     }
     @AfterMethod
     public void goBackToHomepage ( ) {
           driver.findElement(By.linkText("Home")).click() ;
     }
     
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}

