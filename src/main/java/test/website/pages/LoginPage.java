
package test.website.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.website.testbase.TestBase;

public class LoginPage extends TestBase {
  
	@FindBy(xpath = "//*[@href='https://www.udemy.com/join/login-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F']")
	WebElement navLoginButton;
  
	@FindBy(xpath = "//input[@id='email--1']")
	WebElement inputEmailTextBox;
	
	@FindBy(xpath = "//input[@id='id_password']")
	WebElement inputPasswordBox;
	
    @FindBy(xpath = "//input[@id='submit-id-submit']")
    WebElement submitButton;
    
    
    public LoginPage() {
		// TODO Auto-generated constructor stub
       PageFactory.initElements(driver, this);
       
    }
    
	//actions
    public String ValidateTitle () {
    	return driver.getTitle();
    } 
    
    public DashboardPage goToLoginPage() {
    	navLoginButton.click();
    
    	return new DashboardPage();
    	
    }
    
}
