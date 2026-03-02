package com.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D14LoginToOHRM_DDF 
{
	String fPath ="ExcelFile\\OHRM_LoginData.xlsx";
	File file;
	FileInputStream fis;		//read data
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;
	XSSFRow row;
	XSSFCell cell;
	WebDriver driver;
	int index =1;
	
	@Test(dataProvider = "getDetails")
	public void loginToOHRM(String un, String ps) 
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@AfterMethod()
	public void afterMethod() 
	{
		String msg;
		row = sheet.getRow(index);
		cell = row.getCell(2);
		if (driver.getCurrentUrl().contains("dashboard")) 
		{
			msg = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Test Case Pass");
			cell.setCellValue("Pass");
		}
		else 
		{
			msg = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
			System.out.println("Test Case Fail");
			cell.setCellValue("Fail");
		}
		sheet.getRow(index).getCell(3).setCellValue(msg);
		index++;
	}

	@DataProvider
	public Object[][] getDetails()
	{
		int rows = sheet.getPhysicalNumberOfRows();
		
		String[][] loginData = new String[rows-1][2];
		for (int i=0; i<rows-1; i++)
		{
			for(int j=0; j<2 ; j++ )
			{
				cell = sheet.getRow(i+1).getCell(j);
				loginData[i][j] = cell.getStringCellValue();
			}
		}		
		return loginData;
	}

	@BeforeTest
	public void beforeTest() throws IOException 
	{
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);				//not creating workbook --> its reading existing workbook
		sheet = wb.getSheetAt(0);
		
		fos = new FileOutputStream(file); 
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() throws IOException 
	{
		wb.write(fos);
		wb.close();
		fis.close();
		driver.close();
	}

}
