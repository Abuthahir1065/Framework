package com.atmecs.testdata;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.atmecs.constant.ConstantClass;



public class XlsReader{
	
	String filePath;
	public XlsReader(String filePath)
	{
		this.filePath=filePath;
	}
	
   public  Object[][] readData(String sheetName) throws IOException
	{
		Object[][] data;
		XSSFWorkbook workbook;
		workbook=new XSSFWorkbook(this.filePath);
		XSSFSheet sh=workbook.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		System.out.println(rowCount+" Rows");
		int columnCount=sh.getRow(0).getLastCellNum();
		data=new Object[rowCount][columnCount];
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++)
		{ 
			System.out.println("------------------");
			int cellCount=sh.getRow(rowIndex).getLastCellNum();
			
			for(int colIndex=0;colIndex<cellCount;colIndex++)
			{
				String value=sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				data[rowIndex-1][colIndex]=value;
			}
		}
		workbook.close();
		return data;
		
		
	}


}
