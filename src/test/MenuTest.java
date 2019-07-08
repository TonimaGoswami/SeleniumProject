package test;

import static org.junit.Assert.*;
import menus.MainMenu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.EmailNotificationPage;
import pages.LoginPage;

public class MenuTest extends BaseTest {

	private LoginPage loginPage;
	private MainMenu mainMenu;
	private EmailNotificationPage emailNotification;

	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		mainMenu = new MainMenu(driver);
		emailNotification = new EmailNotificationPage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// login
		// menu -> emailSubscriptions
		// check header
				
		loginPage.load();
		loginPage.login();
		mainMenu.gotoEmailSubscriptions();
		String pageHeader = emailNotification.getHeader();
		assertEquals("Email Notification", pageHeader);
	}

}
