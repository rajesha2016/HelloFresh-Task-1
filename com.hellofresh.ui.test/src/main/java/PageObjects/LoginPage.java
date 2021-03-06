package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author r.moharana
 * this class helps in existing user login activity
 * login page: Object and behavior
 */
public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how=How.ID, using="email")
	private WebElement userEmailAddress;
	
	@FindBy(how=How.ID, using="passwd")
	private WebElement userPasswordAddress;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	private WebElement loginInButton;
	
	
	//method to enter existing email address
	public void enter_UserEmailAddress(){
		
		userEmailAddress.sendKeys(RegistrationPage.user_EmailAddress);
		
	}
	
	//method to enter valid password
	public void enter_UserPassword(){
		
		userPasswordAddress.sendKeys(RegistrationPage.user_Password);
	}
	
	//method to click on Login button to navigate to user home page
	public void click_SignInButton(){
		
		loginInButton.click();
	}

}
