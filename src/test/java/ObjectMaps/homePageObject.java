package ObjectMaps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.baseTestClass;

public class homePageObject extends baseTestClass {
	public WebDriver driver;

	public homePageObject(WebDriver driver) {
		this.driver = driver;
	}

	By singIn = By.cssSelector("a[href*='sign_in']");

	By feturecourse = By.xpath("//section[@id='content']/div[1]/div[1]");

	By hader = By.xpath("//div[@class='navbar navbar-default navbar-static-top']/div[1]/nav[1]");

	public loginPageObject getLoginPage() {
		driver.findElement(singIn).click();
		loginPageObject lp = new loginPageObject(driver);
		return lp;
	}

	public WebElement getTextFetaureCourse() {
		return driver.findElement(feturecourse);
	}

	public WebElement validateHader() {
		return driver.findElement(hader);
	}

}
