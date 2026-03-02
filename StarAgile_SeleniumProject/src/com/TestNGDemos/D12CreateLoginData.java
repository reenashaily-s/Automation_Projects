package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D12CreateLoginData 
{
	String fPath ="ExcelFile\\OHRM_LoginData.xlsx";
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 0;

	@Test(dataProvider = "getLoginData")
	public void createLoginData(String un, String ps, String res, String msg)
	{
		sheet.createRow(index).createCell(0).setCellValue(un);
		sheet.getRow(index).createCell(1).setCellValue(ps);
		sheet.getRow(index).createCell(2).setCellValue(res);
		sheet.getRow(index).createCell(3).setCellValue(msg);
		
		index++;
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][]
				{
					new Object[] {"UserName", "Password", "Result", "Message"},
					new Object[] {"admin", "admin123", "Not Run", "NULL"},
					new Object[] {"reena", "admin123", "Not Run", "NULL"},
					new Object[] {"teja", "admin123", "Not Run", "NULL"},
					new Object[] {"mahima", "admin123", "Not Run", "NULL"},
					new Object[] {"tanuja", "admin123", "Not Run", "NULL"},
				};
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException 
	{
		file = new File(fPath);
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("Login Data");	//create sheet with name 0
	}

	@AfterTest
	public void afterTest() throws IOException 
	{
		wb.write(fos);							//write data physically to file
		wb.close();
		fos.close();
	}

}