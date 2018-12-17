package StepDefinitions;

import com.cucumber.listener.Reporter;

import CucumberContext.TestContext;
import PageObjects.CommonPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * @author r.moharana
 * this is common steps for user who wanted to associate with application
 */
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
		Reporter.addStepLog("User launch application url");
	    
	}
	
	@When("^I click on Sign in button$")
	public void i_click_on_Sign_in_button() throws Throwable {
	    
		commonPage.click_SigninButton();
		Reporter.addStepLog("User click on sing in button");
	}

	
	@And("^I click on Log out button$")
	public void i_click_on_Log_out_button() throws Throwable {
	    
		commonPage.click_SingOutButton();	
		Reporter.addStepLog("User click on sing out button");
	}
	
	@And("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    
		testContext.getWebDriverLibrary().closeDriver();
		Reporter.addStepLog("User close the browser after placing the order");
	    
	}

}
