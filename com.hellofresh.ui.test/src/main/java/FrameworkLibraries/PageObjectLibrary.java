package FrameworkLibraries;

import org.openqa.selenium.WebDriver;

import PageObjects.CheckoutPage;
import PageObjects.CommonPage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import PageObjects.UserHomePage;

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

	public LoginPage getLoginPage(){
		
		return (loginPage==null)? loginPage=new LoginPage(driver): loginPage;
	}
	
	public RegistrationPage getRegistrationPage(){
		
		return (registerPage==null)? registerPage=new RegistrationPage(driver): registerPage;
	}
	
	public CheckoutPage getCheckoutPage(){
		
		return (checkoutPage==null)? checkoutPage=new CheckoutPage(driver): checkoutPage;
	}
	
	public CommonPage getCommonPage(){
		
		return (commonPage==null)? commonPage=new CommonPage(driver): commonPage;
	}
	
	public UserHomePage getUserHomePage(){
		
		return (userHomePage==null)? userHomePage=new UserHomePage(driver): userHomePage;
	}

}
