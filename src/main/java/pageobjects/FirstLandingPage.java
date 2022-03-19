package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstLandingPage {

	public WebDriver driver;

	public FirstLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Already a user? Sign in']")
	private WebElement Signin;

	public WebElement Signin() {
		return Signin;
	}
}
