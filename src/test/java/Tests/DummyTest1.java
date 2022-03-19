package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass;

public class DummyTest1 extends BaseClass {

	public WebDriver driver;

	@Test
	public void dummyTest1() throws IOException, InterruptedException {
		System.out.println("Just a simple dummy test 1");
		driver = initializeDriver();
		driver.get("https://www.rediff.com/");
		Thread.sleep(3000);
		driver.close();
	}
}
