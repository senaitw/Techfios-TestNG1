package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scroll {

	WebDriver driver;
	@Test
	public void hoover() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.dell.com/en-us?~ck=mn");
	
	
	WebElement product_Name= driver.findElement(By.id("l1_0"));
	Actions action = new Actions(driver);
	action.moveToElement(product_Name).build().perform();

		
	
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("scroll(0,400)");

	
	}
	}
