package com.TestNGDemos;

import org.testng.annotations.Test;
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

public class D11FriendsData 
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
		cell.setCellValue("Shaily"); 
		
		//row = sheet.createRow(1);	
		cell = row.createCell(1);	
		cell.setCellValue("Sompalli");
		
		sheet.createRow(1).createCell(0).setCellValue("Reena");
		sheet.getRow(1).createCell(1).setCellValue("Maddala");
		
		sheet.createRow(2).createCell(0).setCellValue("Mahima");
		sheet.getRow(2).createCell(1).setCellValue("Maddala");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException 
	{
		file = new File("ExcelFile\\FriendsData.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet();	//create sheet with name 0
	}

	@AfterTest
	public void afterTest() throws IOException 
	{
		wb.write(fos);				//write data physically to file
		wb.close();
		fos.close();
	}

}
