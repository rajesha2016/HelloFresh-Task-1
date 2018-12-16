package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkLibraries.FileReaderLibrary;

public class CommonPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CommonPage(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CLASS_NAME, using="login")
	private WebElement signinButton;
	
	@FindBy(how=How.CSS, using="a.logout")
	private WebElement signoutButton;
	
	
	public void click_SigninButton(){
		
		if(signinButton.isDisplayed()) signinButton.click();
		else{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
			signinButton.click();
		}
		
	}

	public void navigateTo_LoginPage(){
		
		driver.get(FileReaderLibrary.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void click_SingOutButton(){
		
		signoutButton.click();
		
		if(signinButton.isDisplayed()) {
			System.out.println("User sign out successfully");
		}
		
	}

}
