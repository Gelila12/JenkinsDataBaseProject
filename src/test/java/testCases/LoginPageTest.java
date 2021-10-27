package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;
public class LoginPageTest extends TestBase {

	LoginPage loginpageObj;
	//SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() {
		initializeDriver();
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority = 1)
	public void LoginTest() throws  InterruptedException, ClassNotFoundException, SQLException, IOException  {
		loginpageObj.insertUserName("Demo@techfios.com");
		Thread.sleep(4000);
		loginpageObj.insertPassword("abc123");
		Thread.sleep(4000);
		loginpageObj.clickOnSigninButton();
		takeScreenshotAtEndOfTest(driver);
	}

	@Test(priority = 2)
	public void LoginPageTitleTest() throws    InterruptedException, ClassNotFoundException, SQLException, IOException   {
		loginpageObj.insertUserName("Demo@techfios.com");
		Thread.sleep(4000);
		loginpageObj.insertPassword("abc123");
		Thread.sleep(4000);
		loginpageObj.clickOnSigninButton();

		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginpageObj.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}