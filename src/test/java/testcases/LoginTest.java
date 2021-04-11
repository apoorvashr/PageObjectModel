package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.website.pages.LoginPage;
import test.website.testbase.TestBase;

public class LoginTest extends TestBase{

	LoginPage loginPage;
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
	    super();
	}
	
	@BeforeMethod
	public void setup () {
		initialise();
		loginPage =  new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loginPageTest() {
	String title = loginPage.ValidateTitle();	
	Assert.assertEquals(title, "Online Courses - Learn Anything, On Your Schedule | Udemy");
	}
	
	
	@Test(priority =2)
	public void loginTest() {
		loginPage.goToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
