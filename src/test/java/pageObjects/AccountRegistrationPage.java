package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Elements using pageFactory class
	@FindBy(name="firstname") 
	WebElement txtFirstname;
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	//confirmation message elements
	@FindBy(css="div h1")
	WebElement msgConfirmation;
	
	
	//Action methods
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)// generate email id dynamically during runtime, it is a dynamic data
	{
		txtEmail.sendKeys(email);//every customer should have random email id
		
	}

	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	public void checkPolicy()
	{
		chkdPolicy.click();
	}
	public void checkContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
		return(msgConfirmation.getText());
		
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
			
	
}
