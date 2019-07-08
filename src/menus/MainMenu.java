package menus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu extends BaseMenu {
	
	private Duration second = Duration.ofSeconds(1);
	
	public By admin = By.id("menu_admin_viewAdminModule");
	public By configuration = By.id("menu_admin_Configuration");
	public By userManagement = By.id("menu_admin_UserManagement");
	public By emailSubscriptions = By.id("menu_admin_viewEmailNotification");

	public MainMenu(WebDriver driver) {
		super(driver);
	}
	
	public void gotoEmailSubscriptions() {
		// each action in the chain can be added separately
		actions
		.moveToElement(driver.findElement(admin));
		actions
		.pause(second);
		
		// or all actions can be chained together in one statement
		actions
		.moveToElement(driver.findElement(userManagement))
		.moveToElement(driver.findElement(configuration))
		.moveToElement(driver.findElement(emailSubscriptions))
		.click()
		.pause(second);  // another alternative is to wait for selected configuration menu
		
		// when ready to execute, call perform()
		actions.perform();
	}

}
