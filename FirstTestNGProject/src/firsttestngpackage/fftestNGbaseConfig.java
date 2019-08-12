package firsttestngpackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fftestNGbaseConfig {

    String driverPath = "c:\\selenium_web_driver\\GeckoDriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);

    }

    @Test
    public void navigateToUrl() {
        driver.get("http://demo.guru99.com/selenium/guru99home/");
        System.out.println("Title of page = " + driver.getTitle());
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

}
