package tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.gethomePageTitle();

		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void homepageURLTest() {
		String actualURL = homePage.getHomePageURL();

		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
	}

}
