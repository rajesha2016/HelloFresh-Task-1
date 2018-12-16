package StepDefinitions;

import CucumberContext.TestContext;
import PageObjects.CommonPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonSteps {
	
	CommonPage commonPage;
	TestContext testContext;
	
	public CommonSteps(TestContext context){
		testContext=context;
		commonPage=testContext.getPageObjectLibrary().getCommonPage();
	}
	
	
	@Given("^I open homepage url$")
	public void i_open_homepage_url() throws Throwable {
	    
		commonPage.navigateTo_LoginPage();
	    
	}
	
	@When("^I click on Sign in button$")
	public void i_click_on_Sign_in_button() throws Throwable {
	    
		commonPage.click_SigninButton();
	    
	}

	
	@And("^I click on Log out button$")
	public void i_click_on_Log_out_button() throws Throwable {
	    
		commonPage.click_SingOutButton();	
	    
	}
	
	@And("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    
		testContext.getWebDriverLibrary().closeDriver();
	    
	}

}
