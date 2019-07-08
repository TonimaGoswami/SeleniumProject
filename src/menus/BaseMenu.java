package menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMenu {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	
	public BaseMenu(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		actions = new Actions(driver);
	}

}
