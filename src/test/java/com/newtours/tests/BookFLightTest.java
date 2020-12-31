package test.java.com.newtours.tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.com.newtour.pages.FindFlightPage;
import main.java.com.newtour.pages.FlightBookingPage;
import main.java.com.newtour.pages.FlightConfirmationPage;
import main.java.com.newtour.pages.RegistrationConfirmationPage;
import main.java.com.newtour.pages.RegistrationPage;
import test.java.com.tests.BaseTest;

public class BookFLightTest extends BaseTest {
	
	
	private String noOfPassanger;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassanger","expectedPrice"})
	public void setUpParameters(String noOfPassanger,String expectedPrice) {
		this.noOfPassanger=noOfPassanger;
		this.expectedPrice=expectedPrice;
			}
	
	@Test
	public void registrationPage() {
		RegistrationPage register = new RegistrationPage(driver);
		register.goTO();
		register.enterUserDetails("selenium", "docker");
		register.enterUserCredentials("selenium", "docker");
		register.submit();
	}

	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage registerconfirm= new RegistrationConfirmationPage(driver);
		registerconfirm.goToFlightDetailsPage();
	}
	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightBookingPage() {
		FlightBookingPage flightbook = new FlightBookingPage(driver);
		flightbook.selectNumberOfPassanger(noOfPassanger);
		flightbook.goToFindFlights();
	}
	@Test(dependsOnMethods = "flightBookingPage")
	public void findFlightPage() {
		FindFlightPage flightpage = new FindFlightPage(driver);
		flightpage.submitFlightPage();
		flightpage.goToFlightConfirmationPage();
	}
	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage() {
		FlightConfirmationPage flightconfirm = new FlightConfirmationPage(driver);
		String actualprice=flightconfirm.confirmationPage();
		Assert.assertEquals(actualprice, expectedPrice);
	}
	
	}
