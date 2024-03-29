package pagefactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class Guru99Login {
	WebDriver driver;
	
	@FindBy(name="uid")

    WebElement user99GuruName;

    @FindBy(name="password")

    WebElement password99Guru;    

    @FindBy(className="barone")

    WebElement titleText;

    @FindBy(name="btnLogin")
    WebElement login;

    
    public Guru99Login(WebDriver driver) {
    	this.driver = driver;
    	//This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}

	//Set user name in text box
    public void setUserName(String strUserName) {
    	user99GuruName.sendKeys(strUserName);
    }
    
    // Set passswd in text box
    public void setPassword(String strPassword) {
    	password99Guru.sendKeys(strPassword);
    }
    
    // Click on login button
    public void clickLogin() {
    	login.click();
    	}
    //Get the title of Login Page

    public String getLoginTitle(){

    	return    titleText.getText();

    }
    
    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */
    public void loginToGuru99(String strUserName, String strPassword) {
    	// Fill the user name
    	this.setUserName(strUserName);
    	
    	//Fill passwd
    	this.setPassword(strPassword);
    	
    	//click on the login button
    	this.clickLogin();
    }
}
