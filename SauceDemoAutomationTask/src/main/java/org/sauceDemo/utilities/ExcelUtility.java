package org.sauceDemo.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sauceDemo.constants.Constants;

public class ExcelUtility 
{
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh; 
	
	
	public static String stringDataRead(int row, int col, String sheetName) throws IOException
	{				
		f=new FileInputStream(Constants.TEST_DATA_EXCELPATH);
		wb = new XSSFWorkbook(f);		
		sh =wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}
	
	public static String integerDataRead(int row, int col, String sheetName) throws IOException
	{
		f=new FileInputStream(Constants.TEST_DATA_EXCELPATH);
		wb = new XSSFWorkbook(f);
		sh =wb.getSheet(sheetName);
		XSSFRow r= sh.getRow(row);
		XSSFCell c= r.getCell(col);
		int a= (int) c.getNumericCellValue();
		return String.valueOf(a);
	}
}
