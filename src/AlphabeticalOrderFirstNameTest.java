import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlphabeticalOrderFirstNameTest {
	private WebDriver driver;
	private String baseUrl;


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Desktop/IMP-Doc/geckodriver ");
		baseUrl = "http://www.hrm.seleniumminutes.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
		
	}

	@Test
	public void test() {
		
		driver.get(baseUrl);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();
		
		
		
	}

}
