package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice {

@Test
public void practice() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://techfios.com/test/billing/?ng=login/");
	driver.findElement(By.cssSelector("#username")).sendKeys("techfiosdemo@gmail.com");
	driver.findElement(By.cssSelector("#password")).sendKeys("abc123");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	
	String expectedTitle = "Dashboard- TechFios Test Application - Billing";
	Assert.assertEquals(driver.getTitle(), expectedTitle, "Dashboard did not display");
	By Transaction_Menu_Locator = (By.xpath("//ul[@id='side-menu']/descendant::span[text()='Transactions']"));
	By New_Deposite_Locator = (By.linkText("New Deposit"));		
	
	driver.findElement(Transaction_Menu_Locator).click();		
	waitForElement(New_Deposite_Locator,driver,10);
	driver.findElement(New_Deposite_Locator).click();
	
	//select an account
	
	
	
	
	Thread.sleep(3000);
	driver.close();
	driver.quit();
	
	
	


}

private void waitForElement(By Locator, WebDriver driver1, int time) {
	new WebDriverWait(driver1,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
	
}

}


