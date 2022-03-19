package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "login1")
	private WebElement login;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(name = "proceed")
	private WebElement submitLink;

	public WebElement login() {
		return login;
	}

	public WebElement password() {
		return password;
	}

	public WebElement submitLink() {
		return submitLink;
	}
}
