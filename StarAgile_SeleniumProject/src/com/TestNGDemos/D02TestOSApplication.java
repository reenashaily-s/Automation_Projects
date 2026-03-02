package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class D02TestOSApplication {
	@Test(priority = 3)
	public void testLittleBox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://littleboxindia.com/");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
	}
	@Test(priority = 4)
	public void testLibas() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.libas.in/?srsltid=AfmBOoosC9EkK-Vnt6QlbuDLJhsvwUoqSdzBKZkN8sAfT7QoKd4yTL-R");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
	}
	@Test(priority = 2)
	public void testFirstCry() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.firstcry.com/?srsltid=AfmBOopCSYKI3yVo-xTL_NOHcOKjHQaL5qjAhjkKJHMMmRlaMlyXn0G2");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
	}
	@Test(priority = 1)
	public void testOnyc() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://onyc.in/");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
	}
}
