package com.SeleniumWebDriverClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D24HeadlessBrowsers 
{

    public static void main(String[] args) 
    {
    	ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless");				// setting for headless mode of execution
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
	
		List<WebElement>headers = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("Table headers");
		
		for(WebElement th : headers)
			System.out.println(th.getText());
		
		driver.close();
    }
}
