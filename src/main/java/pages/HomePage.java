package pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	
	//1. String Locators
	
	private String search="input[name='search']";
	
	private String searchIcone="div#search button";
	
	private String searchinputBox="div#search input";
	
	private String searchPageHeader="div#content h1";
	
	//2. create page constructor
	
	public HomePage(Page page)
	{
		this.page=page;
		
	}
	
	//3. create actions/methods
	
	public String gethomePageTitle()
	{
	String homePagetitle= page.title();
	System.out.println("Home Page Title :  "+homePagetitle);
	return homePagetitle;
	}
	
	public String getHomePageURL()
	{
		String url= page.url();
		System.out.println("Page URL: "+url);
		System.out.println("Hello");
		return url;
	}
	
	public String doHomePageSearch(String productName)
	{
		page.fill(searchinputBox, productName);
		page.click(searchIcone);
		String header= page.textContent(searchPageHeader);
		System.out.println("Header of the page after search....."+header);
		return header;
	}
	

}
