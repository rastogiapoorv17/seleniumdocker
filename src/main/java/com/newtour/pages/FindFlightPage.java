package main.java.com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="reserveFlights")
	private WebElement firstsubmitbtn;
	
	@FindBy(name="buyFlights")
	private WebElement secondtsubmitbtn;
	
	
	public FindFlightPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void submitFlightPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.firstsubmitbtn));
		this.firstsubmitbtn.click();
	}
	
	public void goToFlightConfirmationPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.secondtsubmitbtn));
		this.secondtsubmitbtn.click();
	}

}
