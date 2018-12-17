package StepDefinitions;

import org.junit.Assert;

import com.cucumber.listener.Reporter;

import CucumberContext.TestContext;
import PageObjects.CheckoutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author r.moharana
 * step definition file for order check out related steps
 */
public class CheckoutPageSteps {
	
	CheckoutPage checkOutPage;
	TestContext testContext;
	
	public CheckoutPageSteps(TestContext context) {
		
		testContext=context;
		checkOutPage=testContext.getPageObjectLibrary().getCheckoutPage();		
	}

	@And("^I click on the Add to cart button$")
	public void i_click_on_the_Add_to_cart_button() throws Throwable {
	    
	    checkOutPage.click_AddToCart();
	    Reporter.addStepLog("user click on add to card button after selecting dress item from the list");
	}

	@And("^I click on Proceed to Checkout button in Cart page$")
	public void i_click_on_Proceed_to_Checkout_button_in_Cart_page() throws Throwable {
	    
		checkOutPage.click_ProceedToCheckoutCartPage();
		Reporter.addStepLog("user click on proceed to checkout button on cart page");
	}

	@And("^I click on Proceed to Checkout button in summary page$")
	public void i_click_on_Proceed_to_Checkout_button_in_summary_page() throws Throwable {
	    
		checkOutPage.click_ProceedToCheckoutSummaryPage();
		Reporter.addStepLog("user click on proceed to checkout button on summary page");
	}

	@And("^I click on Proceed to Checkout button in address page$")
	public void i_click_on_Proceed_to_Checkout_button_in_address_page() throws Throwable {
	    
		checkOutPage.click_ProceedToCheckoutAddPage();
		Reporter.addStepLog("user click on proceed to checkout button on address page");
	}

	@And("^I click on Terms of service check box$")
	public void i_click_on_Terms_of_service_check_box() throws Throwable {
	    
		checkOutPage.click_TermsOfService();
		Reporter.addStepLog("user click on terms of service");
	}

	@And("^I click on Proceed to Checkout button in shipping page$")
	public void i_click_on_Proceed_to_Checkout_button_in_shipping_page() throws Throwable {
	    
		checkOutPage.click_ProceedToCheckoutCarrierPage();
		Reporter.addStepLog("user click on proceed to checkout button on shipping page");
	}

	@And("^I click on payment type as Pay by bank$")
	public void i_click_on_payment_type() throws Throwable {
	    
	    checkOutPage.select_PaymentBankType();
	    Reporter.addStepLog("user select payment type as bank type");
	}

	@And("^I click on confirm order button in payment page$")
	public void i_click_on_confirm_order_button_in_payment_page() throws Throwable {
	    
	    checkOutPage.click_OrderConfirmButton();
	    Reporter.addStepLog("user click on order confirmation button to place the order");
	}

	@Then("^I navigate to Order confirmation page$")
	public void i_navigate_to_Order_confirmation_page() throws Throwable {
	    
		Assert.assertTrue(checkOutPage.verify_OrderCompletionHeaderMessage());
		Reporter.addStepLog("User navigate to confirmation page successfully");
	    
	}

	@And("^I received success message$")
	public void i_received_success_message() throws Throwable {
	    
		Assert.assertTrue(checkOutPage.verify_OrderCompletionMessage());
		Reporter.addStepLog("User receive confirmation message after order place");
	}

	@And("^I am in last step of order process$")
	public void i_am_in_last_step_of_order_process() throws Throwable {
	    
		Assert.assertTrue(checkOutPage.verify_LastStepOrderProcess());
		Reporter.addStepLog("User is in last of shopping");
			    
	}

}
