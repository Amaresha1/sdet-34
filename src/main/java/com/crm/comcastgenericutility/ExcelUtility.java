package com.crm.comcastgenericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Lingaraj
 *
 */

public class ExcelUtility {
	
	
	
	
/**
 * read the data from the cell
 * @param sheetName
 * @param rowNum
 * @param celNum
 * @return
 * @throws Throwable
 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		
		FileInputStream fis  = new FileInputStream(IConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}


		/**
		 * get the row count
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis  = new FileInputStream(IConstants.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			wb.close();
			return sh.getLastRowNum();
		}



		/**
		 * write data into the cell
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @param data
		 * @throws Throwable
		 */

		public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
			FileInputStream fis  = new FileInputStream(IConstants.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IConstants.EXCELPATH);
			wb.write(fos);
			wb.close();
		}
		
		//This method is used to create and read data from dataprovider
		/**
		 * This method is used to read data from excel sheet and provide that data to dataprovider
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public Object[][] readDataForDataProvider(String sheetName) throws Throwable
		{
			//Step 1:
			FileInputStream fis = new FileInputStream(IConstants.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			int lastCell = sheet.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[lastRow][lastCell];
			for(int i=0;i<lastRow;i++)
			{
				for(int j=0;j<lastCell;j++)
				{
					data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
			return data;
			
		}
			
			
		}
	


