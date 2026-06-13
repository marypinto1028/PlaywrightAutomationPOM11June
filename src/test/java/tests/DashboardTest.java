package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import base.BaseTest;
import pages.LoginPage;
import utilities.ExcelUtil;
import pages.DashboardPage;

public class DashboardTest extends BaseTest {


@Test
public void verifyDashboardTitle() {

    LoginPage login = new LoginPage(page);

   // login.login("Admin", "admin123");
	String username = ExcelUtil.getCellData("src/main/resources/testdata.xlsx", "LoginData", 1, 0);

	String password = ExcelUtil.getCellData("src/main/resources/testdata.xlsx", "LoginData", 1, 1);

    DashboardPage dashboard =
            new DashboardPage(page);

    String actualTitle =
            dashboard.getDashboardTitle();
    System.out.println(actualTitle);

    assertEquals(
            actualTitle,
            "Dashboard",
            "Dashboard title is incorrect");
}


}
