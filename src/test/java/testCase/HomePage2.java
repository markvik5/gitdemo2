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

public class HomePage2 extends baseTestClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(baseTestClass.class.getName());

	@BeforeClass
	public void driverinit() {
		driver = initializeDriver();
		log.info("Driver and URL got initialized");
	}

	@Test
	public void ValidatingHeader1() {

		homePageObject hp = new homePageObject(driver);
		log.info(hp.getTextFetaureCourse().getText());
		AssertJUnit.assertEquals(hp.getTextFetaureCourse().getText(), "FEATURED COURSES123");
		AssertJUnit.assertTrue(hp.validateHader().isDisplayed());
		log.info(hp.getTextFetaureCourse().getText());

	}

	@AfterClass
	public void teardown() {
		driver.close();
		log.info("######  test case completed ########");
	}
}
