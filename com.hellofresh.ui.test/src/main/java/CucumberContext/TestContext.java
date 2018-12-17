package CucumberContext;

import FrameworkLibraries.PageObjectLibrary;
import FrameworkLibraries.WebDriverLibrary;

/**
 * @author r.moharana
 * This class initialize WebDriverLibrary & PageObjectLibrary which is used in scripts 
 * 
 */
public class TestContext {
	
	private WebDriverLibrary webDriverLibrary;
	private PageObjectLibrary pageObjectLibrary;
	
	public TestContext(){
		
		webDriverLibrary=new WebDriverLibrary();
		pageObjectLibrary=new PageObjectLibrary(webDriverLibrary.getDriver());
	}
	
	// return WebDriverLibrary object
	public WebDriverLibrary getWebDriverLibrary(){
		return webDriverLibrary;
	}
	
	// return PageObjectLibrary object
	public PageObjectLibrary getPageObjectLibrary(){
		return pageObjectLibrary;
	}

}
