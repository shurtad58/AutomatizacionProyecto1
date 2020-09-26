package com.pruebasAutomatizadas;


import static org.junit.Assert.assertTrue;



import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	
	private WebDriver driver;
	By registerLocator = By.linkText("Register");
	By usernameLocator = By.name("name");
	By emailLocator = By.name("email");
	By passwordLocator = By.name("password");
	By confirmpasswordLocator = By.name("confirm_password");
	By signupBtnLocator = By.xpath("/html/body/main/div/div/div/div[2]/form/button");
	By registeredSuccess = By.xpath("/html/body/main/div[1]");
	By messageErrorPass = By.xpath("/html/body/main/div[2]");
	By messageErrorPassEqual = By.xpath("/html/body/main/div[1]");
	
	
	
	@Before
	public  void abrirPagina() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://proyecto1toptelqa.us-east-1.elasticbeanstalk.com/");
		
	}
	
	@Test
	public void prueba() throws InterruptedException {
		
		driver.findElement(registerLocator).click();
		Thread.sleep(1000);
		driver.findElement(usernameLocator).sendKeys("stiven");
		Thread.sleep(1000);
		driver.findElement(emailLocator).sendKeys("stiven58hur@hotmail.com");
		Thread.sleep(1000);
		driver.findElement(passwordLocator).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(confirmpasswordLocator).sendKeys("1234");
		Thread.sleep(1000);
		
		driver.findElement(signupBtnLocator).click();
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(registeredSuccess));
		assertTrue("The message is not present", driver.findElement(registeredSuccess).isDisplayed());
		Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(.,'You are registered')]"))));
		
		//WebElement MessageElement = driver.findElement(By.xpath("//div[contains(.,'You are registered')]"));
		//Assert.assertTrue(MessageElement.getText().contains("You are registered"), "The error message isn't displayed");
		//Assert.assertTrue(MessageElement.getText().contains("You are registered"), false);
		
		//driver.findElement(registeredSuccess);
		
		
		
		
		
		/*WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("quality - Google Search", driver.getTitle());
		*/
	}
	
	
	@Test
	public void pruebaFalloRegistro() throws InterruptedException {
		
		driver.findElement(registerLocator).click();
		Thread.sleep(1000);
		driver.findElement(usernameLocator).sendKeys("stiven");
		Thread.sleep(1000);
		driver.findElement(emailLocator).sendKeys("desarro@llohotmail.com");
		Thread.sleep(1000);
		driver.findElement(passwordLocator).sendKeys("123");
		Thread.sleep(1000);
		driver.findElement(confirmpasswordLocator).sendKeys("123");
		Thread.sleep(1000);
		
		driver.findElement(signupBtnLocator).click();
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(messageErrorPass));
		assertTrue("The message is not present", driver.findElement(messageErrorPass).isDisplayed());
		Thread.sleep(3000);
		
	}
	@Test
	public void pruebaFalloRegistroPass() throws InterruptedException {
		
		driver.findElement(registerLocator).click();
		Thread.sleep(1000);
		driver.findElement(usernameLocator).sendKeys("stiven");
		Thread.sleep(1000);
		driver.findElement(emailLocator).sendKeys("desarrolloo@hotmail.com");
		Thread.sleep(1000);
		driver.findElement(passwordLocator).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(confirmpasswordLocator).sendKeys("1234567");
		Thread.sleep(1000);
		
		driver.findElement(signupBtnLocator).click();
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(messageErrorPassEqual));
		assertTrue("The message is not present", driver.findElement(messageErrorPassEqual).isDisplayed());
		Thread.sleep(3000);
		
	}
	
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	
		
	
	
	
	
	
	

}
