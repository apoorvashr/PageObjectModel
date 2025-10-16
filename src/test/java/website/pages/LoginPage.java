package website.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@href='https://www.udemy.com/join/login-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F']")
    private WebElement navLoginButton;

    @FindBy(xpath = "//input[@id='email--1']")
    private WebElement inputEmailTextBox;

    @FindBy(xpath = "//input[@id='id_password']")
    private WebElement inputPasswordBox;

    @FindBy(xpath = "//input[@id='submit-id-submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String validateTitle() {
        return driver.getTitle();
    }

    public void goToLoginPage() {
        navLoginButton.click();
    }
}
