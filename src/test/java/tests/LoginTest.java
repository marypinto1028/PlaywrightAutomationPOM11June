package tests;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ExcelUtil;
import utilities.ExtentTestManager;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLogin() {

	    ExtentTestManager.getTest().info("Launching Login Page");



		LoginPage login = new LoginPage(page);

		// login.login("Admin", "admin123");

		String username = ExcelUtil.getCellData("src/main/resources/testdata.xlsx", "LoginData", 1, 0);

		String password = ExcelUtil.getCellData("src/main/resources/testdata.xlsx", "LoginData", 1, 1);

		login.login(username, password);

		DashboardPage dash = new DashboardPage(page);

		assertEquals(dash.getDashboardTitle(), "Dashboard");
		//If you want to see the screenshot of failure under reports>screenshots, uncomment the below
		//Assert.fail("Intentional failure");
	}
}