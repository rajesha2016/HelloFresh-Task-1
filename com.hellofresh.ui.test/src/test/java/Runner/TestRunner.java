package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import FrameworkLibraries.FileReaderLibrary;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features", 
				glue={"stepDefinitions"},
				plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				dryRun=false, 
				monochrome=true
				)
public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport(){
		
		Reporter.loadXMLConfig(new File(FileReaderLibrary.getInstance().getConfigReader().getReportConfigPath()));
	}
	
}

