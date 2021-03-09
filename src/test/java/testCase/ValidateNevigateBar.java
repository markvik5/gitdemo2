package testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectMaps.homePageObject;
import resources.baseTestClass;

public class ValidateNevigateBar extends baseTestClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(baseTestClass.class.getName());

	@BeforeClass
	public void driverinit() {
		driver = initializeDriver();
		log.info("Driver and URL got initialized");
	}

	@Test
	public void ValidatingHeader() {

		homePageObject hp = new homePageObject(driver);

		AssertJUnit.assertTrue(hp.validateHader().isDisplayed());
		log.info("Login succesful");

	}

	@AfterClass
	public void teardown() {
		driver.close();
		log.info("######  test case completed ########");
	}

}
