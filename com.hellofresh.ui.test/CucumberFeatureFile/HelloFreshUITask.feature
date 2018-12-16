# author: RAJESHA KUMAR MOHARANA
Feature: As a new customer
	I want to order clothes from Your Logo
	By creating new account
	
Background: User's repeated steps
	Given I open homepage url
	When I click on Sign in button

@newUserRegistration
Scenario Outline:  Validate new customer can create account by entering all details
	
	And I enter email address
	And I click create an account button
	And I enter my first name as "<firstname>"
	And I enter my last name as "<lastname>" 
	And I enter my street name as "<street>"
	And I enter my city as "<city>"
	And I enter postal code as "<postalcode>"
	And I enter mobile number as "<handynummer>"
	And I click on Register button
	Then My account page is opened
	And I can see my "<firstname>" and "<lastname>" on User Home Page
	And I click on Log out button
	
	Examples:
	|firstname   |lastname|street|city     |postalcode|handynummer|
	|RajeshaKumar|Moharana|CSB   |Bangalore|22222     |9535380046 |
	

@UserLogin
Scenario Outline: Validate existing customer can login to application with valid email and password
	And I enter my registered email
	And I enter valid password
	And I click on Login button
	Then My account page is opened
	And I can see my "<firstname>" and "<lastname>" on User Home Page
	And I click on Log out button
	
	Examples:
	|firstname   |lastname|
	|RajeshaKumar|Moharana|
	
	
@Checkout
Scenario Outline: Verify user can order by checking out selected items
	And I enter my registered email
	And I enter valid password
	And I click on Login button
	And I click on Women button in the header
	And I select "<productName>" product item from page
	And I click on the Add to cart button
	And I click on Proceed to Checkout button in Cart page
	And I click on Proceed to Checkout button in summary page
	And I click on Proceed to Checkout button in address page
	And I click on Terms of service check box
	And I click on Proceed to Checkout button in shipping page
	And I click on payment type as Pay by bank
	And I click on confirm order button in payment page
	Then I navigate to Order confirmation page
	And I received success message
	And I am in last step of order process
	And I close the browser
	
	Examples:
	|productName				|
	|Faded Short Sleeve T-shirts|
	