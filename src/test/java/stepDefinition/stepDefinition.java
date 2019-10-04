package stepDefinition;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefinition extends base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Exception {
	    
		driver =initializeDriver();
	}

	
	@Given("^navigate to the \"([^\"]*)\" site$")
	public void navigate_to_the_site(String arg1) throws Exception {
	    
		driver.get(arg1);
	}

	
	@Given("^Click on Login link in homepage to land on secure sign-in page$")
	public void click_on_Login_link_in_homepage_to_land_on_secure_sign_in_page() throws Exception {
	    
		LandingPage l=new LandingPage(driver);
		if(l.getpopupSize()>0)
			
		{
			l.getpopup().click();
		}
		
		l.getLogin().click();
	}

	
	@When("^User enters valid (.+) and (.+) and logs in$")
    public void user_enters_valid_and_and_logs_in(String username, String password) throws Throwable {
        
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}

	
	@Then("^Verify that the User is successfully logged in$")
	public void verify_that_the_User_is_successfully_logged_in() throws Exception {
	    
		portalHomePage p=new portalHomePage(driver);
		
		Assert.assertTrue(p.getsearchBox().isDisplayed());
		
	}

	 @And("^close browsers $")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }
	
}
