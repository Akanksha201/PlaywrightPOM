package factorypackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {
    	
    	String browserName=prop.getProperty("browser").trim();

        playwright = Playwright.create();

        System.out.println("Browser name is: " + browserName);

        switch (browserName.toLowerCase()) {

        case "chrome":

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setExecutablePath(Paths.get(
                                    "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"))
                            .setHeadless(false)
            );
            break;

        case "chromium":

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );
            break;

        case "firefox":

            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );
            break;

        case "safari":

            browser = playwright.webkit().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );
            break;

        default:
            throw new IllegalArgumentException(
                    "Invalid browser: " + browserName);
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        page.navigate(prop.getProperty("URL").trim());

        return page;
    }
        
        public Properties init_prop()
        {
        	try {
        	FileInputStream ip=new FileInputStream("\\src\\test\\resources\\resources\\config.properties");
        	prop=new Properties();
        	prop.load(ip);
        }catch(FileNotFoundException e)
        	{
        	e.fillInStackTrace();
        	}catch(IOException e)
        	{
        		e.printStackTrace();
        	}
			return prop;
    }
}