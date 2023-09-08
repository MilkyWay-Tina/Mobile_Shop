package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups= {"Sanity","Master"})// grouping the testcases
	public void test_Login()
	{
		logger.info("***** Starting--TC_002_LoginTest*******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAcount");
		
		hp.clickLogin();
		logger.info("Clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing Login details");
		lp.setEmail(rb.getString("email"));//valid email from config.properties
		lp.setPassword(rb.getString("password"));
		lp.clckLogin();
		logger.info("logged in");
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean status=macc.isMyAccountPageExist();
		Assert.assertEquals(status, true,"Invalid login");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished--TC_002_LoginTest*******");
	}

}
