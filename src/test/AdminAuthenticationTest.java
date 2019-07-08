package test;

import org.junit.Before;
import pages.LoginPage;

public class AdminAuthenticationTest extends BaseTest {
	
	private LoginPage loginPage;

	@Before
	public void setUpLogin() throws Exception {
		loginPage = new LoginPage(driver);
		
		loginPage.load();
		loginPage.login();
	}
}
