package main.java.com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstNameTxt;
	
	@FindBy(name="lastName")
	private WebElement lastNameTxt;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name="register")
	private WebElement submit;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
		
	}
	 
	public void goTO() 
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
	}
	
	public void enterUserDetails(String firstname,String lastname)
	{
		this.firstNameTxt.sendKeys(firstname);
		this.lastNameTxt.sendKeys(lastname);
	}
   public void enterUserCredentials(String username, String password)
   {
	   this.userName.sendKeys(username);
	   this.password.sendKeys(password);
	   this.confirmPassword.sendKeys(password);
   }
   
  public void submit()
  {
	  this.submit.click();
	  
  }
}
