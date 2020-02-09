package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Mousehoover {

@Test
	public void mousehoover() throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");	

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.dell.com/en-us?~ck=mn");
	
	//Element library
	//finding xpath of Deals and storing in a container 
	
	WebElement Deals_Menu_Element = driver.findElement(By.xpath("//button[@id='l1_4']"));
	By Workstation_Deals_Locator = By.linkText("Workstation Deals");
	
	Actions action = new Actions(driver);
	action.moveToElement(Deals_Menu_Element).build().perform();
	
	driver.findElement(Workstation_Deals_Locator).click();
	
	
	
	
	driver.close();
	driver.quit();
	
}


}
