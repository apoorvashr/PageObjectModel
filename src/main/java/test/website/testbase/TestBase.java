package test.website.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.website.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	static Properties properties;
	
	public TestBase() {
		
		properties = new Properties();
		try {
			
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\website\\src\\main\\java\\config\\config.properties");
		    try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	   public static void initialise() {
		  
		   String browserName = properties.getProperty("browser");
		   if(browserName.equals("chrome")) {
			   System.setProperty("browser.chrome.browser", "C:\\Users\\lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
			   driver = new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.manage().getCookies();
			   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			   
			   driver.get(properties.getProperty("url"));
			   
			   
		   }
	   }
	
}
