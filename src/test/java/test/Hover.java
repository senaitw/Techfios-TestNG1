package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hover {

	WebDriver driver;
	
	@BeforeMethod 
	public void lunchbroweser() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.dell.com/en-us?~ck=mn");
				
	}
			
	@Test
	public void hoverhover() {
		
//Element library
	//finding xpath of Deals and storing in a container 
	WebElement Deals_Menu_Element = driver.findElement(By.xpath("//button[@id='l1_4']"));
	By Workstation_Deals_Locator = By.linkText("Workstation Deals");
	
	Actions action = new Actions(driver);
	action.moveToElement(Deals_Menu_Element).build().perform();
	
	driver.findElement(Workstation_Deals_Locator).click();
	
}
	@Test
	public void hoverhover2() {
		
	WebElement Deals_Menu_Element = driver.findElement(By.xpath("//button[@id='l1_4']"));
	By Workstation_Deals_Locator = By.linkText("Workstation Deals");
	
	Actions action = new Actions(driver);
	action.moveToElement(Deals_Menu_Element).build().perform();
	
	driver.findElement(Workstation_Deals_Locator).click();
	
}
@AfterMethod
	public void closeEverything() {
	driver.close();
	driver.quit();
		
	}	
	
}
