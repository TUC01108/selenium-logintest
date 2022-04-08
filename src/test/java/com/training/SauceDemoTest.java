package com.training;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoTest {
String browserName ="edge";
	
	WebDriver driver;
	
	@BeforeEach
	public void setup() {
		 if(browserName.equals("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		 }
		 else if(browserName.equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
	}
	
	@Test
	public void testSauceDemo() {
		driver.get("http://www.saucedemo.com");
		driver.manage().window().maximize();
		//locators
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		assertTrue(driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).isDisplayed());
}
	
	@AfterEach
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
