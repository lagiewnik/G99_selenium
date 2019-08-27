//for url: https://demos.telerik.com/kendo-ui/datetimepicker/index
package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class DateTimePicker2 {
	WebDriver driver;
	
	@FindBy(xpath="//span[@aria-controls='datetimepicker_dateview']")
	WebElement selectDate;

	@FindBy(xpath="//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]")
	WebElement nextLink;
	
	@FindBy(xpath="//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]")
	WebElement midLink;
	
	@FindBy(xpath="//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")
	WebElement previousLink;
	
	@FindBy(xpath="//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]")
	List<WebElement> list_AllMonthToBook;
	
	@FindBy(xpath="//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]")
	List<WebElement> list_AllDateToBook;
	
	@FindBy(xpath="//span[@aria-controls='datetimepicker_timeview']")
	WebElement selectTime;
	
	@FindBy(xpath="//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']")
	List<WebElement> allTime;
	
    public DateTimePicker2(WebDriver driver) {
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
