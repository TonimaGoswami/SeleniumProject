package basic;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {
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
	public void locatorExamples() {
		driver.get(baseUrl);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();
		
		String quickLinkText;
		//quickLinkText = driver.findElement(By.className("quickLinkText")).getText();
		//assertEquals("Assign Leave", quickLinkText);
		// OTHER WAY
		//quickLinkText = driver.findElement(By.cssSelector("span.quickLinkText")).getText();
		//assertEquals("Assign Leave", quickLinkText);
		// OTHER WAY
		//quickLinkText = driver.findElement(By.xpath("//span[@class='quickLinkText']")).getText();
		//assertEquals("Assign Leave", quickLinkText);
		
		// Now were are looking for the first img tag in the quickLaunge
		String src;
		//src = driver.findElement(By.xpath("//div[@class='quickLaunge']/a/img")).getAttribute("src");
		//assertTrue(src.contains("ApplyLeave"));
		// OTHER WAY
		
		src = driver.findElement(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/img")).getAttribute("src");
		assertTrue(src.contains("ApplyLeave"));
		// OTHER WAY
		//src = driver.findElement(By.id("dashboard-quick-launch-panel-menu_holder")).findElement(By.tagName("img")).getAttribute("src");assertTrue(src.contains("ApplyLeave"));
		
		// find the img by label
		//src = driver.findElement(By.className("quickLinkText")).findElement(By.xpath(".//../img")).getAttribute("src");
		//assertTrue(src.contains("ApplyLeave"));
		// OTHER WAY
		//src = driver.findElement(By.xpath("//span[@class='quickLinkText']/../img")).getAttribute("src");
		//assertTrue(src.contains("ApplyLeave"));
		// OTHER WAY
		//src = driver.findElement(By.xpath("//span[text() = 'Assign Leave']/../img")).getAttribute("src");
		//assertTrue(src.contains("ApplyLeave"));
		
		
	}
	
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
