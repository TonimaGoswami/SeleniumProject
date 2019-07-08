package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.EmployeeInfoPage;
import test.AdminAuthenticationTest;

public class PimAlphaSortTest extends AdminAuthenticationTest {

	private EmployeeInfoPage pimPage;

	@Before
	public void setUp() throws Exception {
		pimPage = new EmployeeInfoPage(driver);
	}

	@Ignore
	@Test
	public void sortByFirstName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome")));
		pimPage.load();

		pimPage.sortByFirstName();

		// Determine if results are listed on more than 1 page
		WebElement multiple_pages;
		try {
			multiple_pages = driver.findElement(By.cssSelector("ul.paging>li:first-child"));
		} catch (NoSuchElementException e) {
			multiple_pages = null;
		}

		String previous = "";
		while (true) {
			List<WebElement> allFirstNames = driver.findElements(By.xpath("//td[3]/a"));

			for (WebElement firstNameElement : allFirstNames) {
				String current = firstNameElement.getText();

				assertTrue("Expected first name " + previous + " to be alphabetically same or before " + current,
						previous.compareToIgnoreCase(current) <= 0);

				// We are storing the current value for the future (into
				// previous variable)
				previous = current;
			}
			if (multiple_pages == null) {
				break;
			}

			String pagination = driver.findElement(By.cssSelector("ul.paging>li:first-child")).getText();
			String[] pages_description = pagination.split(" ");

			// if on the last page, then break
			if (pages_description[0].contains(pages_description[2])) {
				break;
			}

			// otherwise find out which page you're on
			int pageNum = Integer.valueOf(driver.findElement(By.cssSelector("a.current")).getText());
			// go to the next page
			driver.findElement(By.linkText("Next")).click();
			// wait for the next page to load
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//a[@class='current' and text()=" + (pageNum + 1) + "]")));
		}

	}

	
	@Test
	public void sortByFirstname() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome")));
		pimPage.load();
		pimPage.sortByFirstName();
		
		String previous = "";
		while(true) {
			List<WebElement> allFirstNames = driver.findElements(By.xpath("//td[3]/a"));
			for(WebElement firstName: allFirstNames) {
				String current = firstName.getText();
				
				assertTrue("Expected '"+ previous +"' to be alphabetically before '"+ current +"'",
						previous.compareToIgnoreCase(current) <= 0);
				previous = current;
			}
			
			String[] pagination;
			
			try {
				pagination = driver.findElement(By.cssSelector(".paging .desc"))
						.getText().split(" ");
			}
			catch (NoSuchElementException e){
				break;
			}
			
			if (pagination[0].contains(pagination[2])) {
				break;
			}
			
			int pageNum = Integer.valueOf(driver.findElement(By.cssSelector("a.current")).getText());
			driver.findElement(By.linkText("Next")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//a[@class='current' and text()='"+ (pageNum + 1) +"']")));
		}
	}
}
