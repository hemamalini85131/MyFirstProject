package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration()
	{
		//logger.info("*****Starting the Test Execution**********");
	try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Thread.sleep(3000);
		//logger.warn("----------Asserting the Confirmation message------------");
		
	if(!confmsg.equalsIgnoreCase("Your Account Has Been Created!"))
			{
		// logger.error("Error in the Program, test failed");
	    // logger.debug("Debug logs");
	     Assert.fail();
	     }
	else
	{
	    Assert.assertTrue(true);
	   // logger.info("*******Test Passed****************");
	}
	}
	catch(Exception e)
	{
	
		Assert.fail(e.getMessage());
	}
	
	
	
	
}}
