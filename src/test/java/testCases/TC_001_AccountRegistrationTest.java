package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Regression","Master"})// grouping the testcases
	
	void test_account_Registration()
	{
		
		logger.debug("Application Logs..........");
		logger.info("***** Starting--TC_001_AccountRegistrationTest*******");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked My Account"); 
		
		hp.clickRegister();
		logger.info("Clicked Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");//randomly generated
		regpage.setTelephone(randomNumber());
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.checkPolicy();
		regpage.checkContinue();
		logger.info("Clicked Continue");
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg,"Your Account Has Been Created!","Test Failed");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		logger.info("***** Finished--TC_001_AccountRegistrationTest*******");
	}
}
