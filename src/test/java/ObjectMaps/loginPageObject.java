package ObjectMaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObject {

	public WebDriver driver;

	public loginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement txtboxUsername;

	@FindBy(id = "user_password")
	WebElement txtboxPassword;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement btnLogin;

	@FindBy(xpath = "//div[@class='main-hero']/div[1]")
	WebElement ErrorMessages;

	@FindBy(css = "[href*='password/new']")
	WebElement ForgetPassword;

	public WebElement enterUsername() {
		return txtboxUsername;
	}

	public WebElement enterPassword() {
		return txtboxPassword;
	}

	public WebElement clickonLogin() {
		return btnLogin;
	}

	public WebElement errorMessage() {
		return ErrorMessages;
	}

	public forgetPasswordObject forgetPassword() {
		ForgetPassword.click();
		forgetPasswordObject fp = new forgetPasswordObject(driver);
		return fp;
	}
}
