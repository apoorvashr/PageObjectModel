package website.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import website.util.TestUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver; // instance driver
    protected Properties properties;

    public TestBase() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("config.properties not found");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void initialise() {
        String browserName = properties.getProperty("browser");
        if (browserName == null) {
            System.out.println("Browser not specified in config.properties");
            return;
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            // Optionally set chromedriver path
            // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.get(properties.getProperty("url"));
        }
    }

    public WebDriver getDriver() {
        return driver; // getter for pages
    }
}
