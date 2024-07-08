package org.sauceDemo.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sauceDemo.constants.Constants;

/**
 * Utility class for reading data from an Excel file.
 */
public class ExcelUtility 
{
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh; 
	
	
	/**
     * Reads string data from the specified Excel sheet.
     * @param row The row index (0-based) from which to read data.
     * @param col The column index (0-based) from which to read data.
     * @param sheetName The name of the Excel sheet to read data from.
     * @return The string value read from the specified cell.
     * @throws IOException If an I/O error occurs.
     */
	public static String stringDataRead(int row, int col, String sheetName) throws IOException
	{		
		try {
		String path = Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
		f=new FileInputStream(path);
		wb = new XSSFWorkbook(f);		
		sh =wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
		}catch(Exception e)
		{
			throw new RuntimeException("TestData excel sheet not found");
		}
	}
	
	/**
     * Reads integer data from the specified Excel sheet.
     * @param row The row index (0-based) from which to read data.
     * @param col The column index (0-based) from which to read data.
     * @param sheetName The name of the Excel sheet to read data from.
     * @return The integer value read from the specified cell, converted to string.
     * @throws IOException If an I/O error occurs.
     */
	public static String integerDataRead(int row, int col, String sheetName) throws IOException
	{
		try {
			String path = Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
		f=new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sh =wb.getSheet(sheetName);
		XSSFRow r= sh.getRow(row);
		XSSFCell c= r.getCell(col);
		int a= (int) c.getNumericCellValue();
		return String.valueOf(a);
		}catch(Exception e)
			{
				throw new RuntimeException("TestData excel sheet not found");
			}
	}
}
