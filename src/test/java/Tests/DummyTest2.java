package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.BaseClass;

public class DummyTest2 extends BaseClass {

	public WebDriver driver;

	@Test
	public void dummyTest2() throws IOException, InterruptedException {
		System.out.println("Just a simple dummy test 2");

		driver = initializeDriver();
		driver.get("https://www.rediff.com/");

		Thread.sleep(3000);
		Assert.assertTrue(false);
	}

	@Test(priority = 1)
	public void skipTest() {
		throw new SkipException("Skipping this test");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
