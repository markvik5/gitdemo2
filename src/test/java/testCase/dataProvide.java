package testCase;

import org.testng.annotations.DataProvider;

public class dataProvide {

	@DataProvider
	public Object[][] valuePassed() {
		return new Object[][] { { "abc@gmail.com", "paas" }, { "mark@gmail.com", "1234" } };
	}

}
