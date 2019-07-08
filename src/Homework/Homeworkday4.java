package Homework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homeworkday4 {
	private WebDriver driver;
	private String baseUrl;
	private WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Desktop/IMP-Doc/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://hrm.seleniumminutes.com";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSearchMyNameFirstRow() {
		wait = new WebDriverWait(driver, 7);
		
		//Part A: Search by employee name
		//1) Go to hrm.seleniumminutes.com
		//2) Login: admin/Password
		//3) CLick the PIM tab in the top left corner
		//4) In the Employee Name field enter the name 'Smith'
		//5) Click the Search button
		//6) Check that the first row of the results table contains an employee with last name 'Smith'
		//Hint: Don't forget to wait where appropriate! 
		//We will discuss how to use WebDriverWait in the next class, but for now please use sleep() as a temporary solution.
	
		String expected = "Smith";
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Password");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		WebElement empNameField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("#empsearch_employee_name_empName.inputFormatHint")));
		empNameField.clear();
		empNameField.sendKeys(expected + Keys.ESCAPE);
		
		driver.findElement(By.id("searchBtn")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("input#empsearch_employee_name_empName[value='Smith']")));
		
		
		String lastName = driver.findElement(By.xpath("//*[@id='resultTable']//td[4]/a")).getText();
		assertEquals(expected, lastName);
		
		//Part B: this part is optional since we have not yet tried this out in class together 
		//7) Implement a for-loop to check that all rows within the results table contain employees with the last name 'Smith'	
		
		List<WebElement> allLastNameElements = driver.findElements(By.xpath("//*[@id='resultTable']//td[4]/a"));
		for (WebElement el: allLastNameElements) {
			String name = el.getText();
			assertTrue(name.contains(expected));
		}
		
		//Extra Challenge: (because we have to yet discussed how to do this)
		//8) Modify your code to search by employee name 'Smith' and by Job Title 'QA Manager'
		//9) Check that each resulting row contains an employee with last name 'Smith' that is also a 'QA Manager'
		//Hint: https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html
		
		new Select(driver.findElement(
				By.id("empsearch_job_title"))).selectByVisibleText("QA Manager");
		
		driver.findElement(By.id("searchBtn")).click();
		
		//TODO: replace with explicit wait
		sleep(1);
		
		List<WebElement> allRowElements = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
		for (WebElement el: allRowElements) {
			String name = el.findElement(By.xpath("//td[4]/a")).getText();
			String jobTitle = el.findElement(By.xpath("//td[5]")).getText();
			
			assertTrue(name.contains(expected));
			assertEquals("QA Manager", jobTitle);
		}

	}
	
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
