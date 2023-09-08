package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	// dataProviderClass= classname.class
	 @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)//as DataProviders is created in Utilities folder .class is mention in annotation
	 
	 public void test_loginDDT(String email,String pwd,String exp)
	 {
		 logger.info("*******Started-TC_003_LoginDDT************* ");
		 
		 try {
			
		
		 HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAcount");
			
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Providing Login details");
			lp.setEmail(email);//valid email from config.properties
			lp.setPassword(pwd);
			lp.clckLogin();
			logger.info("logged in");
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean status=macc.isMyAccountPageExist();
			
			// login details validation
			if (exp.equals("Valid"))// if data is valid, login is success, test is passed
			{
				if(status==true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else {//if data is true , login is failed, test is failed
					Assert.assertTrue(false);
				}
				
			}
			if(exp.equals("Invalid"))// if data is invalid and login s success, test is failed
			{
				if(status==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else {// if data is invalid and login is failed, test is passed
					Assert.assertTrue(true);
				}
				
			}
		 }
		 catch(Exception e)
		 {
			 Assert.fail();
		 }
		 logger.info("*******Finished-TC_003_LoginDDT************* ");
	 }
	 
	

}
