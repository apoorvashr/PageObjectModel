package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import website.pages.LoginPage;
import website.testbase.TestBase;

public class LoginTest extends TestBase {

    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        initialise(); // initialize driver in base
        loginPage = new LoginPage(driver); // pass instance driver
    }

    @Test(priority = 1)
    public void loginPageTest() {
        String title = loginPage.validateTitle();
        Assert.assertEquals(title, "Online Courses - Learn Anything, On Your Schedule | Udemy");
    }

    @Test(priority = 2)
    public void loginTest() {
        loginPage.goToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
