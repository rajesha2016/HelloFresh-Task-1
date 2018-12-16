package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public boolean verify_MyAccount(){
		
		
		if(driver.getCurrentUrl().contains("controller=my-account") && myAccountHeaderText.getText().equals("MY ACCOUNT")){
			System.out.println("User Account successfully validated");
			return true;
		}
		else return false;
		
	}
	
	public boolean verify_WelcomeMessage(){
		
		
		if(welcomeMessage.getText().contains(("Welcome to your account.")))return true;
		return false;
		
	}
	
	public boolean verify_UserNameonHomePage(String firstName, String lastName){
		
		
		if(userAccountName.getText().contains(firstName+" "+lastName)){
			
			return true;
		}
		
		return false;
	}
	
	public void click_WomenButton(){
		
		if(womenButton.isDisplayed()) womenButton.click();
	}
	
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
