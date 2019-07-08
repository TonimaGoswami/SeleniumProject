package test;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@Before
	public void baseSetUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Desktop/IMP-Doc/geckodriver");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void baseTearDown() throws Exception {
		driver.quit();
	}
}
