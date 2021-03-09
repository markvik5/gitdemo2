package ObjectMaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgetPasswordObject {
	public WebDriver driver;

	public forgetPasswordObject(WebDriver driver) {
		this.driver = driver;
	}

	By emailId = By.cssSelector("[type='email']");
	By btnSubmit = By.xpath("//input[@name='commit']");

	public WebElement enterEmail() {
		return driver.findElement(emailId);
	}

	public WebElement submitBtn() {
		return driver.findElement(btnSubmit);
	}

}
