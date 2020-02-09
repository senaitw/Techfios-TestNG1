package test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pract2 {

	
	@Test
	public void pract() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		//Instantiate chrome driver class 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=login/");
		
		By userName_locator = By.xpath("//input[@id='username']");
		By passwar_Locator = By.xpath("//input[@id='password']");
		By submit_Locator = By.xpath("//button[@type='submit']");
		
		By bank_cash = By.xpath("//ul[@id='side-menu']/descendant::i[5]");
		By new_account = By.xpath("//a[text()='New Account']");
		
		By accountTitle_locator = By.cssSelector("#account");
		By descr_Locator = By.xpath("//input[@id='description']");
		By balance_Locator = By.cssSelector("#balance");
		By submit_locator = By.xpath("//button[@class='btn btn-primary']");
		By acc_succ_Locator = By.xpath("//div[@class='alert alert-success fade in']");
	
		
		
		driver.findElement(userName_locator).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(passwar_Locator).sendKeys("abc123");
		driver.findElement(submit_Locator).click();
		
		driver.findElement(bank_cash).click();
		driver.findElement(new_account).click();
		Thread.sleep(3000);
		
		Random rd = new Random();
		String account = "Test"+ rd.nextInt(999);
		
		driver.findElement(accountTitle_locator).sendKeys("" + account);
		driver.findElement(descr_Locator).sendKeys("masterl");
		driver.findElement(balance_Locator).sendKeys(account);
	
		driver.findElement(submit_locator).click();
	
	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(acc_succ_Locator));
	Thread.sleep(3000);
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scroll(0,1000)");
	
	//Storing table list
	//"*//table/tbody/descendant::td"));
	 
	List<WebElement> tablelist = driver.findElements(By.xpath("//td[contains(text(),'Test189')]"));
	Assert.assertTrue(isnewaccount(account,tablelist));
	System.out.println(tablelist.get(0).getText());
	
	for(WebElement delete:tablelist) {
		
	}
	
	
	}

	private boolean isnewaccount(String account, List<WebElement> tablelist) {
		for(int i=0;i<tablelist.size();i++) {
			if(account.equalsIgnoreCase(tablelist.get(i).getText()));
		return true;
		}
		return false;
		
		
		
	}
}	

