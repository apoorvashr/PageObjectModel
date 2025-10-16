package website.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import website.testbase.TestBase;

public class DashboardPage extends TestBase{

    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}
