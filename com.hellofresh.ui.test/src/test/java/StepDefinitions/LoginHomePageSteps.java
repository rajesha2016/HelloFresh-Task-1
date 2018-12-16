package StepDefinitions;

import CucumberContext.TestContext;
import PageObjects.LoginPage;
import cucumber.api.java.en.And;

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
	    
	}

	@And("^I enter valid password$")
	public void i_enter_valid_password() throws Throwable {
	    
		loginPage.enter_UserPassword();	    
	}
	

	@And("^I click on Login button$")
	public void i_click_on_login_button() throws Throwable {
	    
		loginPage.click_SignInButton();
	    
	}

}
