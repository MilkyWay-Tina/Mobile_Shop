package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);// super keyword invokes the parent class constructor "BasePage"
	}

	//Elements
	@FindBy(xpath=" //span[contains(text(),'My Account')]")
	WebElement lnkMyaccount;
	
	@FindBy(linkText="Register")
    WebElement  lnkRegister;

	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	//Action Methods
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()// Login link element added
	{
		lnkLogin.click();
	}
}
