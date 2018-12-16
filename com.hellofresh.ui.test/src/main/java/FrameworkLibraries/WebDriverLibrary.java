package FrameworkLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Enums.DriverType;
import Enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLibrary {
	
	private static WebDriver driver;
	 private static DriverType driverType;
	 private static EnvironmentType environmentType;
	 
	 
	 
	 public WebDriverLibrary() {
		 
		 driverType = FileReaderLibrary.getInstance().getConfigReader().getBrowser();
		 environmentType = FileReaderLibrary.getInstance().getConfigReader().getEnvironment();
	 }
	 
	 public WebDriver getDriver() {
		 if(driver == null) driver = createDriver();
		 return driver;
	 }
	 
	 private WebDriver createDriver() {
		 
	    switch (environmentType) {     
	         case LOCAL : driver = createLocalDriver();
	          break;
	         case REMOTE : driver = createRemoteDriver();
	          break;
	    }
	    return driver;
	    
	 }
	 
	 private WebDriver createRemoteDriver() {
		 throw new RuntimeException("RemoteWebDriver is not yet implemented");
	 }
	 
	 private WebDriver createLocalDriver() {
		 
	        switch (driverType) {     
	        	case FIREFOX : 
	        		WebDriverManager.firefoxdriver().setup();
	        		driver = new FirefoxDriver();
	        		break;
	        	case CHROME : 
	        		WebDriverManager.chromedriver().setup();
	        		driver = new ChromeDriver();
	        		break;
	        	case INTERNETEXPLORER : 
	        		WebDriverManager.iedriver().setup();
	        		driver = new InternetExplorerDriver();
	        		break;
	        }
	 
	        if(FileReaderLibrary.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(FileReaderLibrary.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	        return driver;
	 } 
	 
	 
	 public void closeDriver() {
		 driver.close();
		 driver.quit();
	 }

}
