package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingNewWindow {
WebDriver driver;
@BeforeMethod
	public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	}
	
	
@Test
	public void handling_new_window() throws InterruptedException {
				
		driver.get("https://www.yahoo.com/");
		
		By Search_Field_Locater = By.cssSelector("input#header-search-input");
		By W3_Link_Locator = By.linkText("XPath Tutorial - w3schools.com");
		By SQL_lINK_lOCATER = By.linkText("SQL");
		
		driver.findElement(Search_Field_Locater).sendKeys("xpath");
		driver.findElement(Search_Field_Locater).sendKeys(Keys.ENTER);
		driver.findElement(W3_Link_Locator).click();
		
		Thread.sleep(3000);
		//System.out.println(driver.getWindowHandles());
		//WindowHandler loop 
		
		for(String WindowHandle: driver.getWindowHandles()) {
			driver.switchTo().window(WindowHandle);
		}
				
		driver.findElement(SQL_lINK_lOCATER).click();
		
		
	}	
@AfterMethod
public void closeEverything() {
	//driver.close();
	//driver.quit();
}

}