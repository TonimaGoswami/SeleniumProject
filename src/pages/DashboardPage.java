package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public String getWelcomeMessage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome"))).getText();
	}

	public void logout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();
	}

}
