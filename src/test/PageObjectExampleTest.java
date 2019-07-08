package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.DashboardPage;
import pages.LoginPage;


public class PageObjectExampleTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage homePage;

	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new DashboardPage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		loginPage.load();
		loginPage.login();
		String actualWelcome = homePage.getWelcomeMessage();
		assertEquals("Welcome Admin", actualWelcome);
		homePage.logout();
	}

}
