package Homework;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homeworkday5 {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Desktop/IMP-Doc/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://hrm.seleniumminutes.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testInvalidCredentials() {
//		Part 1: Invalid login using invalid credentials
//
//		1) Go to hrm.seleniumminutes.com
//		2) Login using username 'admin' and some incorrect value for password (e.g. '12345678')
//		3) Click 'LOGIN' button
//		4) Check that 'Invalid credentials' warning is displayed
		driver.get(baseUrl);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("12345678");
		driver.findElement(By.id("btnLogin")).click();
		
		//TODO: replace with explicit wait
		sleep(1);
		String message = driver.findElement(By.id("spanMessage")).getText();
		assertEquals("Invalid credentials", message);
	}
	
	@Test
	public void testMissingPassword() {
//		Part 2: Invalid login without a password
//
//		1) Go to hrm.seleniumminutes.com
//		2) Login using username 'admin' and leave the password field empty
//		3) Click 'LOGIN' button
//		4) Check that 'Password cannot be empty' warning is displayed
		
		driver.get(baseUrl);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		//TODO: replace with explicit wait
		sleep(1);
		String message = driver.findElement(By.id("spanMessage")).getText();
		assertEquals("Password cannot be empty", message);
	}
	
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
