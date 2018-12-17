package StepDefinitions;

import com.cucumber.listener.Reporter;

import CucumberContext.TestContext;
import PageObjects.LoginPage;
import cucumber.api.java.en.And;

/**
 * @author r.moharana
 * existing user login related steps methods
 */
public class LoginHomePageSteps {
	
	LoginPage loginPage;
	TestContext testContext;
	
	public LoginHomePageSteps(TestContext context){
		
		testContext=context;
		loginPage=testContext.getPageObjectLibrary().getLoginPage();
	}
	
	
	@And("^I enter my registered email$")
	public void i_enter_registered_email() throws Throwable {
	    
		loginPage.enter_UserEmailAddress();
		Reporter.addStepLog("User enter registered email address");
	    
	}

	@And("^I enter valid password$")
	public void i_enter_valid_password() throws Throwable {
	    
		loginPage.enter_UserPassword();	    
		Reporter.addStepLog("User enter valid password to access account");
	}
	

	@And("^I click on Login button$")
	public void i_click_on_login_button() throws Throwable {
	    
		loginPage.click_SignInButton();
		Reporter.addStepLog("User click on the login button to navigate to user home page");
	    
	}

}
