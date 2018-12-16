package StepDefinitions;

import CucumberContext.TestContext;
import PageObjects.RegistrationPage;
import cucumber.api.java.en.And;

public class RegistrationPageSteps {
	
	RegistrationPage registrationPage;
	TestContext testContext;

	public RegistrationPageSteps(TestContext context){
		
		testContext=context;
		registrationPage=testContext.getPageObjectLibrary().getRegistrationPage();
		
	}
	
	@And("^I enter email address$")
	public void i_enter_email_address() throws Throwable {
	    
	    registrationPage.enter_UserEmailAddress();
	}
	
	@And("^I click create an account button$")
	public void i_click_create_an_account_button() throws Throwable {
	    
	    registrationPage.click_CreateAccountButton();
	}

	@And("^I enter my first name as \"([^\"]*)\"$")
	public void i_enter_my_first_name_as(String firstName) throws Throwable {
	    
	   registrationPage.enter_FirstName(firstName);
	   
	}

	@And("^I enter my last name as \"([^\"]*)\"$")
	public void i_enter_my_last_name_as(String lastName) throws Throwable {
	    
		 registrationPage.enter_LastName(lastName);
		 registrationPage.enter_Password();
		 registrationPage.select_DateOfBirth();
	}

	@And("^I enter my street name as \"([^\"]*)\"$")
	public void i_enter_my_street_name_as(String streetName) throws Throwable {
	    
		registrationPage.enter_StreetAddress(streetName);
		
	}

	@And("^I enter my city as \"([^\"]*)\"$")
	public void i_enter_my_city_as(String cityName) throws Throwable {
	    
		registrationPage.enter_CityName(cityName);
		registrationPage.select_State();
	}

	@And("^I enter postal code as \"([^\"]*)\"$")
	public void i_enter_postal_code_as(String postalCode) throws Throwable {
	    
		registrationPage.enter_PostalCode(postalCode);
		registrationPage.select_Country();		
	    
	}

	@And("^I enter mobile number as \"([^\"]*)\"$")
	public void i_enter_mobile_number_as(String mobileNumber) throws Throwable {
	    
		registrationPage.enter_MobileNumber(mobileNumber);
	}

	@And("^I click on Register button$")
	public void i_click_on_Register_button() throws Throwable {
	    
		registrationPage.click_RegisterButton();
	    
	}

}
