package FrameworkLibraries;

import org.openqa.selenium.WebDriver;

import PageObjects.CheckoutPage;
import PageObjects.CommonPage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import PageObjects.UserHomePage;

/**
 * @author r.moharana
 * This class helps to create every page object. 
 * If applications have multiple step definitions file then with the help of this class we can avoid object creation again and again
 * step definition files
 */
public class PageObjectLibrary {
	
	
	private WebDriver driver;
	private LoginPage loginPage;
	private RegistrationPage registerPage;
	private CheckoutPage checkoutPage;
	private CommonPage commonPage;
	private UserHomePage userHomePage;
	
	 
	public PageObjectLibrary(WebDriver driver) {
		 
		 this.driver = driver;
		 
	}

	//initialize LoginPage object, if already present then return the current instance.
	public LoginPage getLoginPage(){
		
		return (loginPage==null)? loginPage=new LoginPage(driver): loginPage;
	}
	
	//initialize RegistrationPage object, if already present then return the current instance.
	public RegistrationPage getRegistrationPage(){
		
		return (registerPage==null)? registerPage=new RegistrationPage(driver): registerPage;
	}
	
	//initialize CheckoutPage object, if already present then return the current instance.
	public CheckoutPage getCheckoutPage(){
		
		return (checkoutPage==null)? checkoutPage=new CheckoutPage(driver): checkoutPage;
	}
	
	//initialize CommonPage object, if already present then return the current instance.
	public CommonPage getCommonPage(){
		
		return (commonPage==null)? commonPage=new CommonPage(driver): commonPage;
	}
	
	//initialize UserHomePage object, if already present then return the current instance.
	public UserHomePage getUserHomePage(){
		
		return (userHomePage==null)? userHomePage=new UserHomePage(driver): userHomePage;
	}

}
