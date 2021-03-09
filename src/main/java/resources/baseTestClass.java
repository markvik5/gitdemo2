package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseTestClass {
	public WebDriver driver;
	public static String chromeDriverPath = "//home//vikash//Documents//ChromeDriver//chromedriver";

	public WebDriver initializeDriver() {
		Properties pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
			pro.load(fis);

			String browserName = pro.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");

				driver = new ChromeDriver(options);
				driver.get(pro.getProperty("url"));

			} else if (browserName == "firefox") {

			} else {

			}
			// timeout

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.manage().window().maximize();
			return driver;
		}
	}

	public String takeScreenShotonFail(String methodName, WebDriver driver) {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File scr = tk.getScreenshotAs(OutputType.FILE);
		String desPath = System.getProperty("user.dir") + "//reports//" + methodName + ".png";
		try {

			FileUtils.copyFile(scr, new File(desPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return desPath;
		}
	}

}
