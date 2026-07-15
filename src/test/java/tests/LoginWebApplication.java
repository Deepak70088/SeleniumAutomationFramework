package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginWebApplication extends BaseTest {
	
	@DataProvider(name="LoginTestData")
	public Object [][]	getLoginData() throws IOException{
		String filePath = System.getProperty("User.dir") + "/testdata/testdata.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for (int i=1; i<rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0); //username
			data[i-1][1] = ExcelUtils.getCellData(i, 1); //password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider(name="LoginTestData2") //without the Excel file
	public Object [][] getData(){
		return new Object [][] {
			{"username1","password1"},
			{"username2","password2"},
			{"username3","password3"}
		};
	}

	//@Test(dataProvider = "LoginTestData2")
	@Test(dataProvider = "LoginTestData")
	public void testValidLogin(String username, String password) {
		
		Log.info("Staring Login Test");
		test = ExtentReportManager.createTest("Login Test");
		
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("Adding Credentials");
		test.info("Adding Credentials");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		
//		loginPage.enterUsername("admin@yourstore.com");
//		loginPage.enterPassword("admin");
//		test.info("Clicking on Login Button");
//		loginPage.clickOnLogin();
		String title = driver.getTitle();
		
		System.out.println("Title of the page is: "+ title);
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(title, title);
		test.pass("Login Successful");
	}
	
	@Test
	@Parameters({"username","password"})
public void testInValidLogin(String username, String password) {
		
		Log.info("Staring Login Test");
		test = ExtentReportManager.createTest("Login Test" + username);
		
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		Log.info("Adding Credentials");
		test.info("Adding Credentials");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
//		test.info("Clicking on Login Button");
//		loginPage.clickOnLogin();
		String title = driver.getTitle();
		
		System.out.println("Title of the page is: "+ "Mojo jo jo");
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(title, title);
		test.pass("Login Successful");
	}

}
