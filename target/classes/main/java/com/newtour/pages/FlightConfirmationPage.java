package main.java.com.newtour.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath= "//font[contains(text(),'Flight Itinerary Page')]")
	private WebElement flightiternarypage;
	
	@FindBy(xpath= "//font[contains(text(),'USD')]")
	private List<WebElement> prices;
	
	@FindBy(id ="sign-on")
	private WebElement signoff;
	
	public FlightConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public String confirmationPage() {
		this.wait.until(ExpectedConditions.visibilityOfAllElements(this.flightiternarypage));
		System.out.println(this.flightiternarypage.getText());
		System.out.println(this.prices.get(1).getText());
		
	String price= this.prices.get(1).getText();
	return price;
	}

}
