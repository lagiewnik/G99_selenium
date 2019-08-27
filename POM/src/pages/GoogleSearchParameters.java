package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchParameters {
	WebDriver driver;
	
	By searchField = By.name("q");
	By searchFirstSugestion = By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/ul/li[1]/div/div[1]/div/span");
	String searchText = "holdem texas";
        
    public GoogleSearchParameters(WebDriver driver) {
    	this.driver = driver;
	}

	//Set user name in text box
    public void setSearchText(String strSearchText) {
    	driver.findElement(searchField).clear();
    	driver.findElement(searchField).sendKeys(strSearchText);
    }
    //Get prompt text from google
        
    public String getFirstSugestion(){
    	List <WebElement> lstGoogle = driver.findElement(By.xpath("//ul[@role='listbox']"))
    			.findElements(By.xpath("//li[@role='presentation']"));
    	return    lstGoogle.get(0).getText();

    }
}
