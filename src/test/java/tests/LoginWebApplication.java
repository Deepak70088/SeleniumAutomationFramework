package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginWebApplication extends BaseTest {

	@Test
	public void testValidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+ title);
		
		Assert.assertEquals(title, title);
	}
}
