package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import factorypackage.PlaywrightFactory;
import pages.HomePage;

public class HomePageTest {
	
	PlaywrightFactory pf;
	Page page;
	
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp()
	{
		pf= new PlaywrightFactory();
		page=pf.initBrowser("chrome");
		
		homePage=new HomePage(page);
	}
	
	
	@Test
	public void homePageTititleTest()
	{
		String actualTitle=homePage.gethomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
	}
	
	@Test
	public void homepageURLTest()
	{
		String actualURL= homePage.getHomePageURL();
		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
	}
	
	@Test
	public void homePageHeadertest()
	{
		String actualHeader=homePage.doHomePageSearch("Macbook");
		Assert.assertEquals(actualHeader, "Search - Macbook");
		
	}
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}

}
