package basetest;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import factorypackage.PlaywrightFactory;
import pages.HomePage;

public class BaseTest {
	

	HomePage homePage;
	Page page;
	protected PlaywrightFactory pf;
	protected Properties prop;
	
	@BeforeTest
	public void setUp()
	{
		pf= new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		
		homePage=new HomePage(page);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}

}
