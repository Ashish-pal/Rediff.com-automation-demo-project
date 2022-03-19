package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FirstLandingPage;
import pageobjects.SigninPage;
import pageobjects.WriteMail;
import resources.BaseClass;

public class Login extends BaseClass {

		WebDriver driver;
		FirstLandingPage landingPage;
		SigninPage signin;
		WriteMail writeMail;
		
	    @Given("^Open Any Browser$")
	    public void open_any_browser() throws IOException {
	        driver = initializeDriver();
	    }
	    
	    @And("^Navigate to Login Page$")
	    public void navigate_to_login_page() throws InterruptedException{
	    	driver.get(prop.getProperty("url"));
	    	landingPage = new FirstLandingPage(driver);
			landingPage.Signin().click();
			Thread.sleep(3000);
	    }

	    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password){
	    	signin = new SigninPage(driver);
			signin.login().sendKeys(email);
			signin.password().sendKeys(password);
		
	    }

	    @And("^User clicks on Login Button$")
	    public void user_clicks_on_login_button(){
	    	signin.submitLink().click();
	    }

	    @Then("^Verify user is able to successfully login$")
	    public void verify_user_is_able_to_successfully_login(){
	    	writeMail = new WriteMail(driver);
	    	Assert.assertTrue(writeMail.writemail().isDisplayed());
	    }  
	    
	    @After
	    public void tearDown() {
			driver.close();
		}
}