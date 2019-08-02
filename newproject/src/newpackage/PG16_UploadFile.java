// https://www.guru99.com/upload-download-file-selenium-webdriver.html

package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import org.openqa.selenium.remote.DesiredCapabilities;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class PG16_UploadFile {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System Property for Gecko Driver
    			System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
    			
    	// Initialize Gecko Driver using Desired Capabilities Class  
    			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("marionette", true);
    			@SuppressWarnings("deprecation")
				WebDriver driver = new FirefoxDriver(capabilities);
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			
    			String url = "http://demo.guru99.com/test/upload/";
    			driver.get(url);
    			
    			WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

    	        // enter the file path onto the file-selection input field
    	        uploadElement.sendKeys("d:\\tmp\\test.txt");

    	        // check the "I accept the terms of service" check box
    	        driver.findElement(By.id("terms")).click();

    	        // click the "UploadFile" button
    	        driver.findElement(By.name("send")).click();
    	        
    	        /* ====================
    	         * Download file with external program wget
    	         */
    	        url = "http://demo.guru99.com/test/yahoo.html";
    	        driver.get(url);
    	        
    	        //Find button with download
    	        WebElement downloadBtn = driver.findElement(By.id("messenger-download"));
    	        //get url for download from href attribute of download button
    	        String sourceLocation = downloadBtn.getAttribute("href");
    	        System.out.println(sourceLocation);
    	        //Setup command syntax for wget
    	        String wget_command = "cmd /c wget -P x: " + sourceLocation;
    	        System.out.println(wget_command);
    	        //initialize download by calling wget
    	        try {
    	        	Process exec = Runtime.getRuntime().exec(wget_command);
    	        	int exitVal = exec.waitFor();
    	        	System.out.println("Exit value: " + exitVal);
    	        }
    	        catch (InterruptedException | IOException ex) {
    	        	System.out.println(ex.toString());
    	        }
    	        
    	        driver.quit();
    }

}