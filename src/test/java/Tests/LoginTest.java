package Tests;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.FirstLandingPage;
import pageobjects.SigninPage;
import pageobjects.WriteMail;
import resources.BaseClass;

public class LoginTest extends BaseClass {
	public WebDriver driver;
	Logger log;

	@Test(dataProvider = "getsigninData")
	public void login(String email, String password, String status) throws IOException, InterruptedException {

		FirstLandingPage landingPage = new FirstLandingPage(driver);
		landingPage.Signin().click();
		log.debug("Clicked on Signin Button");
		Thread.sleep(3000);
		SigninPage signin = new SigninPage(driver);
		signin.login().sendKeys(email);
		log.debug("Enter Email Data");
		signin.password().sendKeys(password);
		log.debug("Enter Password");
		signin.submitLink().click();
		log.debug("Click on Signin Submit button");

		WriteMail writeMail = new WriteMail(driver);
		// Assert.assertTrue(writeMail.writemail().isDisplayed());

		String result = null;
		try {
			if (writeMail.writemail().isDisplayed()) {
				log.debug("User login success");
				result = "Success";
			}
		} catch (Exception e) {
			log.debug("User login failed");
			result = "FailedTest";
		}

		if (result.equals(status)) {
			log.info("Login test pass successful");
		} else {
			log.error("LoginTest Failed");
		}
		// Assert.assertEquals(result, status);
	}

	@BeforeMethod
	public void openApp() throws IOException {

		log = LogManager.getLogger(LoginTest.class.getName());

		driver = initializeDriver();
		log.debug("Browser launched");
		driver.get(prop.getProperty("url"));
		log.debug("Open URL");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser Closed Here");
	}

	@DataProvider
	public Object[][] getsigninData() {

		Object[][] data = { { "yiroco@rediffmail.com", "Password@123", "Success" },
				{ "kuchbhi@gmail.com", "password", "FailedTest" } };
		return data;
	}
}
