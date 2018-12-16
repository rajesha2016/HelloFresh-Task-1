package StepDefinitions;

import org.junit.Assert;

import com.cucumber.listener.Reporter;

import CucumberContext.TestContext;
import PageObjects.UserHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UserHomePageSteps {
	
	UserHomePage userHomePage;
	TestContext testContext;
	
	public UserHomePageSteps(TestContext context) {
		
		testContext=context;
		userHomePage=testContext.getPageObjectLibrary().getUserHomePage();
	}
	
	@And("^I click on Women button in the header$")
	public void i_click_on_Women_button_in_the_header() throws Throwable {
	    
		userHomePage.click_WomenButton();
		Reporter.addStepLog("User click the Women Link");
	    
	}

	@And("^I select \"([^\"]*)\" product item from page$")
	public void i_select_product_item_from_page(String productName) throws Throwable {
	    
		userHomePage.select_Dress(productName);
			    
	}
	
	@Then("^My account page is opened$")
	public void my_account_page_is_opened() throws Throwable {
	    
		Assert.assertTrue(userHomePage.verify_WelcomeMessage());
		Assert.assertTrue(userHomePage.verify_MyAccount());
	    
	}

	@And("^I can see my \"([^\"]*)\" and \"([^\"]*)\" on User Home Page$")
	public void i_can_see_my_on_User_Home_Page(String firstName,String lastName) throws Throwable {
	   
		Assert.assertTrue(userHomePage.verify_UserNameonHomePage(firstName, lastName));
	    
	}

}
