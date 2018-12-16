package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import CucumberContext.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
TestContext testContext;
	
	public Hooks(TestContext context){
		testContext=context;
	}
	
	@Before
	public void beforeSteps(Scenario scenario){
		
		Reporter.assignAuthor(" Rajesha Kumar Moharana ");
	}
	
	@After
	public void afterScenario(Scenario scenario){
		
		if (scenario.isFailed()) {
			 String screenshotName = scenario.getName().replaceAll(" ", "_");
			 try {
				 
			 //This takes a screenshot from the driver at save it to the specified location
			 File sourcePath = ((TakesScreenshot) testContext.getWebDriverLibrary().getDriver()).getScreenshotAs(OutputType.FILE);
			 
			 //Building up the destination path for the screenshot to save
			 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");
			 
			 //Copy taken screenshot from source location to destination location
			 Files.copy(sourcePath, destinationPath);   
			 
			 //This attach the specified screenshot to the test
			 Reporter.addScreenCaptureFromPath(destinationPath.toString());
			 } catch (IOException e) {
				 
			 } 
		}
		
				
	}

}
