package test.java.com.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	
protected WebDriver driver;
	
	@BeforeTest	
	public void setDriver(ITestContext ctx) throws MalformedURLException {
		
		String host= "18.222.84.60";
		DesiredCapabilities dc;
		
		if(System.getProperty("BROWSER")!= null&& System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
		{
			dc= DesiredCapabilities.firefox();
		}
		else
		{
			dc= DesiredCapabilities.chrome();
		}
		if(System.getProperty("HUB_HOST")!= null)
		{
			host= System.getProperty("HUB_HOST");
		}
		
		String testname= ctx.getCurrentXmlTest().getName();
		String completeurl= "http://" + host + ":4444/wd/hub";
		dc.setCapability("name", testname);
		this.driver = new  RemoteWebDriver(new URL(completeurl), dc);
	    
	}
	
	@AfterTest
	public void quit() {
		this.driver.quit();
	}
}
