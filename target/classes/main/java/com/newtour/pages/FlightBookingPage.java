package main.java.com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookingPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="passCount")
	private WebElement passangers;
	
	@FindBy(name="findFlights")
	private WebElement submit;
	
	public FlightBookingPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void selectNumberOfPassanger(String noOfPassangers)
	{
		this.wait.until(ExpectedConditions.elementToBeClickable(this.passangers));
		Select select= new Select(passangers);
		select.selectByValue(noOfPassangers);
	}
	
	public void goToFindFlights()
	{
		this.submit.click();
	}
}
