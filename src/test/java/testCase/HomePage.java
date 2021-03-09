package testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ObjectMaps.forgetPasswordObject;
import ObjectMaps.homePageObject;
import ObjectMaps.loginPageObject;
import resources.baseTestClass;

public class HomePage extends baseTestClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(baseTestClass.class.getName());

	@BeforeMethod
	public void driverinit() {
		driver = initializeDriver();
		log.info("Driver and URL got initialized");
	}

	@Test(dataProviderClass = dataProvide.class, dataProvider = "valuePassed")
	public void navigateToHomePage(String user, String pass) {

		homePageObject hp = new homePageObject(driver);
		loginPageObject lp = hp.getLoginPage();

		lp.enterUsername().sendKeys(user);
		lp.enterPassword().sendKeys(pass);
		lp.clickonLogin().click();
		log.info("Login succesful");

		forgetPasswordObject fp = lp.forgetPassword();
		fp.enterEmail().sendKeys("vikash@gmail.com");
		fp.submitBtn().click();
		log.info("forget password succesful");

	}

	@AfterMethod
	public void teardown() {
		driver.close();
		log.info("######  test case completed ########");
	}
}
