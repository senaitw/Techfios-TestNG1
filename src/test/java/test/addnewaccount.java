package test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addnewaccount {
WebDriver driver;
	@Test
	public void AddNewAccount() throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("http://techfios.com/test/billing/?ng=login/");
	
	driver.findElement(By.cssSelector("input#username")).sendKeys("techfiosdemo@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	String expected_title = "Dashboard- TechFios Test Application - Billing";
	Assert.assertEquals(driver.getTitle(), expected_title, "DBT did not display");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@id='side-menu']/descendant::span[1]")).click();
	driver.findElement(By.xpath("//ul[@id='side-menu']/descendant::span[8]")).click();
	driver.findElement(By.xpath("//a[text()='New Account']")).click();
	
	
	
	
	Random rd =new Random();
	//Storing random formula
	String accountadd_ele = "Test"+ rd.nextInt(999);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Brave" +accountadd_ele);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='description']")).sendKeys("GetJobSoon"+ accountadd_ele);
	driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("10");
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	Thread.sleep(3000);
	
	new WebDriverWait(driver,40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-success fade in']")));
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scroll(0,20000)");
	
	//Storing table content in a list 
	List<WebElement> tablecont_ele =driver.findElements(By.xpath("//table/descendant::td"));
	Assert.assertTrue(isMatchMyAcc(accountadd_ele,tablecont_ele));
	
//	System.out.println(tablecont_ele.get(5).getText());
	Thread.sleep(3000);
		
//for(int i=0;i<tablecont_ele.size();i++) {
	//if(accountadd_ele.equals(tablecont_ele)) {
		//driver.findElements(accountadd_ele).get(i).click();
		
	}
	


	public boolean isMatchMyAcc(String accountadd_ele, List<WebElement> tablecont_ele) {
		for(int i=0;i<tablecont_ele.size();i++) {
			if(accountadd_ele.equalsIgnoreCase(tablecont_ele.get(i).getText()));
		return true;
		
		}
		return false;
		
		
		
	}

			
	}


	
	
	
	

