package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import base.BaseTest;
import pages.LoginPage;
import utilities.ExcelUtil;
import utilities.ExtentManager;
import utilities.ExtentTestManager;
import pages.DashboardPage;

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
	}
}