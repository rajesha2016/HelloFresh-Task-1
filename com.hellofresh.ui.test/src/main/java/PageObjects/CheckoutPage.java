package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author r.moharana
 * this class helps in order checkout related activities
 * corresponding test logic is written inside this class
 * checkout page: Object and behavior
 */
public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME, using="Submit")
	private WebElement addToCartButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	private WebElement proceedToCheckoutCartPage;
	
	@FindBy(how=How.NAME, using="processAddress")
	private WebElement proceedToCheckoutAddressPage;
	
	@FindBy(how=How.ID, using="uniform-cgv")
	private WebElement termsOfService;
	
	@FindBy(how=How.NAME, using="processCarrier")
	private WebElement proceedToCheckoutCarrierPage;
	
	@FindBy(how=How.CSS, using="h1")
	private WebElement orderCompletionHeaderMessage;
	
	@FindBy(how=How.XPATH, using="//*[@class='cheque-indent']/strong")
	private WebElement orderCompletionMessage;
	
	@FindBy(how=How.XPATH, using="//li[@id='step_end' and @class='step_current last']")
	private WebElement lastStepOrderProcess;
	
	//method to click on add to cart button
	public void click_AddToCart(){
		
		if(addToCartButton.isDisplayed()) addToCartButton.click();
	}
	
	//method to click on proceed to checkout button on cart page
	public void click_ProceedToCheckoutCartPage(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
		
	}
	
	//method to click on proceed to checkout button on summary page
	public void click_ProceedToCheckoutSummaryPage(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
		
	}
	
	//method to click on proceed to checkout button on address page
	public void click_ProceedToCheckoutAddPage(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
		
	}
	
	//method to click on term of service
	public void click_TermsOfService(){
		
		if(termsOfService.isDisplayed()) termsOfService.click();
		
	}
	
	//method to click on proceed to checkout button on carrier page
	public void click_ProceedToCheckoutCarrierPage(){
		
		if(proceedToCheckoutCarrierPage.isDisplayed()) proceedToCheckoutCarrierPage.click();
	}
	
	//method to select payment option: here Bank Type
	public void select_PaymentBankType(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
		
	}
	
	//method to click on order confirmation button
	public void click_OrderConfirmButton(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
		
	}
	
	//method to verify order completion header text message and the application url
	public boolean verify_OrderCompletionHeaderMessage(){
		
		if(driver.getCurrentUrl().contains("controller=order-confirmation") && 
				orderCompletionHeaderMessage.getText().trim().equals("ORDER CONFIRMATION")){
			
			return true;
		}
		return false;
	}
	
	//method to verify order completion message
	public boolean verify_OrderCompletionMessage(){
		
		if(orderCompletionMessage.getText().contains("Your order on My Store is complete.")) {
			
			return true;
		}
		
		return false;
	}
	
	//method to last step of order process
	public boolean verify_LastStepOrderProcess(){
		
		if(lastStepOrderProcess.isDisplayed()) return true;
		
		return false;
	}

}
