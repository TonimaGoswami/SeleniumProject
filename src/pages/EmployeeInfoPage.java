package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployeeInfoPage extends BasePage {

	public EmployeeInfoPage(WebDriver driver) {
		super(driver);
		pageUrl = super.pageUrl + "/symfony/web/index.php/pim/viewEmployeeList";
	}

	public void sortByFirstName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("First (& Middle) Name"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.ASC")));
	}
}
