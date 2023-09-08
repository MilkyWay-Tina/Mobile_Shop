package  testBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;//logging

// RESUSABLE CLASS


public class BaseClass {

	public static WebDriver driver;//WebDriver is set STATIC , to refer same driver instance
	
	public Logger logger;// import org.apache.logging.log4j.Logger
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})// grouping the testcases
	@Parameters("browser")
	public void setUp(String br)
	{
		logger=LogManager.getLogger(this.getClass());// instantiate and to get the current class log details
		
		rb=ResourceBundle.getBundle("config"); //load the config.properties file
		// below -using ChromeOptions , disabling the text"Chrome is controlled by automation tester"
		
		ChromeOptions options=new ChromeOptions();// EdgeOptions
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		//WebDriverManager.chromedriver().setup();  //setup not required in selenium 4.6.0 as it is in built in selenium library
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver(options);// options passed in chrome driver
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
        }
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();// delete all the browser specific cookies, pre populated info from browser.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL1")); //get the KEyvalue from config.properties
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups= {"Master","Sanity","Regression"})// grouping the testcases
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
	String generatedString=RandomStringUtils.randomAlphabetic(10);
	return generatedString;
	}
	
	public String randomNumber()
	{
	String generatedString2= RandomStringUtils.randomNumeric(10);
	return generatedString2;
	 
	}
	public String randomAlphaNumeric()//also use alphanummeric method
	{
	String str=RandomStringUtils.randomAlphabetic(4);
	String num=RandomStringUtils.randomNumeric(3);
	return (str+"@"+num);
	 
	}
	 public String captureScreen(String tname) throws  IOException { //ON TEST FAILURE this method is called
		 
	/* below three steps is written in one single line
		 SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		   Date dt=new Date();
		  String TimeStamp= df.format(dt);*/
		  
		 
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		 
		 TakesScreenshot takeScreenshot=(TakesScreenshot) driver;//TakesScreenshot is an interface, typecasting drive instance
		File source= takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_"+ timeStamp +".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		 return destination;
	 }
}


