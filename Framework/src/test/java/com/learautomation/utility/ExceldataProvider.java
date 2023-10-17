package com.learautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.learautomation.pages.LoginPage;

public class ExceldataProvider {
	XSSFWorkbook wb;
	
	public ExceldataProvider()
	{
		File src = new File("C:\\Users\\muskan.begum\\Downloads\\Workspace_for_framework\\Framework\\TestData\\Data.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			System.out.println("unable to read excel file "+e.getMessage());
		}
	}
	//method overloading 
	public String getStringData(int sheetIndex, int row, int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue(); 
	}
	public String getStringData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue(); 
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue(); 

	}
	
	
	 
}
