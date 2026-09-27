package basetest;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;

import factorypackage.PlaywrightFactory;
import pages.HomePage;

public class BaseTest {

	protected PlaywrightFactory pf;
	protected Page page;
	protected HomePage homePage; // Properties prop;

	@BeforeMethod
	public void setUp() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser("chrome");
		homePage = new HomePage(page);
	}

	@AfterMethod
	public void tearDown() {
		if (page != null) {
			page.context().browser().close();
		}
	}

	
}
