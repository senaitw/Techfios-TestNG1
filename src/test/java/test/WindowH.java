package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowH {

	WebDriver driver;
	@Test
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	
		driver.get("https://www.yahoo.com/");
	
		By Search_Field_Locater = By.cssSelector("input#header-search-input");
		By W3_School_Locater =By.linkText("XPath Tutorial - w3schools.com");
		//By SQL_Locator = By.linkText("SQL");
		By SQL_LOCATORS = By.xpath("//div[@class='w3-bar w3-left']/descendant::a[text()='SQL']");
		
		driver.findElement(Search_Field_Locater).sendKeys("xpath");
		driver.findElement(Search_Field_Locater).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(W3_School_Locater).click();
		
		//driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(30000);
		
		for(String WindowHandle: driver.getWindowHandles()) {
			driver.switchTo().window(WindowHandle);
		}
		
		//driver.findElement(SQL_Locator).click();
		driver.findElement(SQL_LOCATORS).click();
	}
}