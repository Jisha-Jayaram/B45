package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test(priority = 1)
	public void testInValidLogin()  {
		String un=Excel.getCellData(INPUTXL_PATH, "InvalidLogin",1, 0);
		String pw=Excel.getCellData(INPUTXL_PATH, "InvalidLogin",1, 1);
		
//		1. Enter valid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		extentTest.log(Status.INFO, "Enter Invalid user name:"+un);
		
//		2. Enter valid password
		loginPage.setPassword(pw);
		extentTest.log(Status.INFO, "Enter Invalid password:"+pw);
		
//		3. click on login button
		loginPage.clickLoginButton();
		extentTest.log(Status.INFO, "Click on login Button");
		
//		4. verify that home page is displayed
		EnterTimeTrackPage ettPage=new EnterTimeTrackPage(driver);
		boolean result = ettPage.verifyLogoutIsDisplayed(wait);
		Assert.assertTrue(result,"Home Page is not Displayed");
		extentTest.log(Status.INFO, "Verify Home Page is displyed");
		
	}

}
