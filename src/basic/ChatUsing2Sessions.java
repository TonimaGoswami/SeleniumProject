package basic;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatUsing2Sessions {
	String baseUrl = "http://www.cometchat.com/demo";
	private WebDriver chat1;
	private WebDriver chat2;
	private WebDriverWait wait1;
	private WebDriverWait wait2;


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tanu/Desktop/IMP-Doc/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/tanu/Desktop/chromedriver");
		chat1 = new ChromeDriver();
		chat1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     wait1 = new WebDriverWait(chat1, 5);
	     
	     
		chat2 = new FirefoxDriver();
		chat2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait2 = new WebDriverWait(chat2, 5);
	}

	@After
	public void tearDown() throws Exception {
		chat1.quit();
		chat2.quit();
	}

	@Test
	public void test() {
		chat1.get(baseUrl);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("fresno-no-button"))).click();
		chat1.switchTo().frame(chat1.findElement(By.id("comechat_synergy_iframe")));
		String userId1 = chat1.findElement(By.id("comechat_welcome_username")).getText();
		
		chat2.get(baseUrl);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("fresno-no-button"))).click();
		chat2.switchTo().frame(chat2.findElement(By.id("comechat_synergy_iframe")));
		
		String userId2 = chat2.findElement(By.id("comechat_welcome_username")).getText();
		
	}

}
