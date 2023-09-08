package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath="//h2[text()='My Account']")//My Account page heading
WebElement myaccHeading;


@FindBy(linkText="Logout")//My Account page- > Logout page
WebElement linkLogout;

public boolean  isMyAccountPageExist() //My account heading display status
{
	try {
	return (myaccHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return (false);
	}
}
public void clickLogout() {

linkLogout.click();
}

}
