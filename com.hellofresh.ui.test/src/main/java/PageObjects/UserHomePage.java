package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author r.moharana
 * steps for the user home page activities
 * UserHome page: Object and behavior
 */
public class UserHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public UserHomePage(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(how=How.LINK_TEXT, using="Women")
	private WebElement womenButton;
	
	@FindBy(how=How.CSS, using="h1.page-heading")
	private WebElement myAccountHeaderText;
	
	@FindBy(how=How.XPATH,using="//a[@class='account']/span")
	private WebElement userAccountName;
	
	@FindBy(how=How.CLASS_NAME,using="info-account")
	private WebElement welcomeMessage;
	
	//method to verify account header text and current url 
	public boolean verify_MyAccount(){		
		
		if(driver.getCurrentUrl().contains("controller=my-account") && myAccountHeaderText.getText().equals("MY ACCOUNT")){
			return true;
		}
		else return false;		
	}
	
	//method to verify welcome message text after login
	public boolean verify_WelcomeMessage(){
		
		if(welcomeMessage.getText().contains(("Welcome to your account.")))return true;
		return false;		
	}
	
	//verify logged in user name on user home page and return the boolean value
	public boolean verify_UserNameonHomePage(String firstName, String lastName){
		
		if(userAccountName.getText().contains(firstName+" "+lastName)){
			
			return true;
		}
		
		return false;
	}
	
	//click on women button to shop
	public void click_WomenButton(){
		
		if(womenButton.isDisplayed()) womenButton.click();
	}
	
	//select dress based on the product name
	public void select_Dress(String productName){
		
		List<WebElement> productList=driver.findElements(By.className("product-name"));
		
		for(WebElement list:productList){
			
			if(list.getText().trim().equalsIgnoreCase(productName)) {
				list.click();
				break;
			}
			
		}
	}

}
