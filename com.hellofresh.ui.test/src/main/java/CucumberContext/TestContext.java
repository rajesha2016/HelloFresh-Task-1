package CucumberContext;

import FrameworkLibraries.PageObjectLibrary;
import FrameworkLibraries.WebDriverLibrary;

public class TestContext {
	
	private WebDriverLibrary webDriverLibrary;
	private PageObjectLibrary pageObjectLibrary;
	
	public TestContext(){
		webDriverLibrary=new WebDriverLibrary();
		pageObjectLibrary=new PageObjectLibrary(webDriverLibrary.getDriver());
	}
	
	public WebDriverLibrary getWebDriverLibrary(){
		return webDriverLibrary;
	}
	
	public PageObjectLibrary getPageObjectLibrary(){
		return pageObjectLibrary;
	}

}
