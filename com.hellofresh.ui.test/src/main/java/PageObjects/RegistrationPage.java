package PageObjects;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author r.moharana
 * this class helps in registering a new user and it activities
 */
public class RegistrationPage {
	
	WebDriver driver;
	WebDriverWait wait;
	private static String timeStamp=String.valueOf(new Date().getTime());
	public static String user_EmailAddress="hf_challenge_"+timeStamp+"@hf"+timeStamp.substring(5)+".com";
	public static String user_Password="pass@123";
	
	public RegistrationPage(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="email_create")
	private WebElement newEmailAddress;
	
	@FindBy(how=How.ID, using="passwd")
	private WebElement userPassword;
	
	@FindBy(how=How.ID, using="SubmitCreate")
	private WebElement createAccountButton;
	
	@FindBy(how=How.ID, using="customer_firstname")
	private WebElement userFirstName;
	
	@FindBy(how=How.ID, using="customer_lastname")
	private WebElement userLastName;
	
	@FindBy(how=How.ID, using="address1")
	private WebElement UserStreetAddress;
	
	@FindBy(how=How.ID, using="city")
	private WebElement userCityName;
	
	@FindBy(how=How.ID, using="id_state")
	private WebElement userState;
	
	@FindBy(how=How.ID, using="postcode")
	private WebElement userPostalCode;
	
	@FindBy(how=How.ID, using="id_country")
	private WebElement userCountry;
	
	@FindBy(how=How.ID, using="phone_mobile")
	private WebElement userMobileNumber;
	
	@FindBy(how=How.ID, using="alias")
	private WebElement userAliasAddress;
	
	@FindBy(how=How.ID, using="days")
	private WebElement days;
	
	@FindBy(how=How.ID, using="months")
	private WebElement months;
	
	@FindBy(how=How.ID, using="years")
	private WebElement years;
	
	@FindBy(how=How.ID, using="submitAccount")
	private WebElement registerButton;
	
	
	// method to enter new email address for new user
	public void enter_UserEmailAddress(){
		
		if(newEmailAddress.isDisplayed()) newEmailAddress.sendKeys(user_EmailAddress);
		else{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("email_create")));
			newEmailAddress.sendKeys(user_EmailAddress);
		}
	}
	
	//method to click on create account button to fill personal details
	public void click_CreateAccountButton(){
		
		createAccountButton.click();
	}
	
	//enter the first name in the personal details page
	public void enter_FirstName(String firstName){
		
		if(userFirstName.isDisplayed()) userFirstName.sendKeys(firstName);
	}
	
	//enter the last name in the personal details page
	public void enter_LastName(String lastName){
		
		if(userLastName.isDisplayed()) userLastName.sendKeys(lastName);
	}
	
	//enter the password in the personal details page
	public void enter_Password(){
		
		if(userPassword.isDisplayed()) userPassword.sendKeys(user_Password);
	}
	
	//enter the street address in the personal details page
	public void enter_StreetAddress(String streetAddress){
		
		if(UserStreetAddress.isDisplayed()) UserStreetAddress.sendKeys(streetAddress);
	}
	
	//enter the city name in the personal details page
	public void enter_CityName(String cityName){
		
		if(userCityName.isDisplayed()) userCityName.sendKeys(cityName);
	}
	
	//enter the postal code in the personal details page
	public void enter_PostalCode(String postCode){
		
		if(userPostalCode.isDisplayed()) userPostalCode.sendKeys(postCode);
	}
	
	//enter the mobile number in the personal details page
	public void enter_MobileNumber(String mobileNumber){
		
		if(userMobileNumber.isDisplayed()) userMobileNumber.sendKeys(mobileNumber);
	}
	
	
	//select date of the birth from drop down
	public void select_DateOfBirth(){
		
		Select bDay=new Select(days);
		bDay.selectByValue("6");
		
		Select bMonth=new Select(months);
		bMonth.selectByValue("6");
		
		Select bYear=new Select(years);
		bYear.selectByValue("1988");
	}
	
	// select state from drop down
	public void select_State(){
		
		Select state=new Select(userState);
		state.selectByValue("7");
		
	}
	
	//enter the country in the personal details page
	public void select_Country(){
		
		Select country=new Select(userCountry);
		country.selectByValue("21");
		
	}
	
	// click on register button to register the user
	public void click_RegisterButton(){
		
		if(registerButton.isDisplayed()) registerButton.click();
	}

}
