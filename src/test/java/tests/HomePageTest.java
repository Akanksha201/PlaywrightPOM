package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import basetest.BaseTest;
import constants.Constants;
import factorypackage.PlaywrightFactory;
import pages.HomePage;

public class HomePageTest extends BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	
	HomePage homePage;
	
	
	
	
	@Test
	public void homePageTititleTest()
	{
		String actualTitle=homePage.gethomePageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void homepageURLTest()
	{
		String actualURL= homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("URL").trim());
	}
	
	
	
	@DataProvider
	public Object[][] getProductData()
	{
		return new Object[][] {
			
			{"Macbook" },{"iMac" },{"Samsung" }};
		}
	

@Test(dataProvider="getProductData")
public void searchTest(String productName)
{
	String actualSeachHeader=homePage.doHomePageSearch(productName);
	Assert.assertEquals(actualSeachHeader, "Search- " +productName);



	
	
	
	
	
	
	
	

}
