//for url: http://demo.guru99.com/test/
package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class Guru99DateTimePicker {
	WebDriver driver;
	
	@FindBy(xpath="//form//input[@name='bdaytime']")
	WebElement dateBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;
    
	@FindBy(xpath = "//body/div[2]")
	WebElement outputText;
	
    public Guru99DateTimePicker(WebDriver driver) {
    	this.driver = driver;
    	//This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}

	//Set user name in text box
    public void setDateAndTime(String strDate, String strTime) {
    	//Fill date as mm/dd/yyyy as 09/25/2013 get as "09252013"
    	dateBox.sendKeys(strDate);
    	
    	////Press tab to shift focus to time field
    	dateBox.sendKeys(Keys.TAB);
    
    	//Fill time as 14:45 written as "0245PM"
        dateBox.sendKeys(strTime);
    }
    
    public void submitDateTimePicker() {
    	submitBtn.click();
    }
    
    public String getOutputText() {
    	return outputText.getText();
    }
   
}
