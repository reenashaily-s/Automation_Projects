package com.TestNGDemos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D10WriteToExcel 
{
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
		
	@Test
	public void writeToExcel() 
	{
		row = sheet.createRow(0);	// creates 1st row in sheet
		cell = row.createCell(0);	// creates 1st cell in 1st row
		
		cell.setCellValue("Reena");  
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException 
	{
		file = new File("ExcelFile.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("My Sheet");		
	}

	@AfterTest
	public void afterTest() throws IOException 
	{
		wb.write(fos);				//write data physically to file
		wb.close();
		fos.close();
	}
}
