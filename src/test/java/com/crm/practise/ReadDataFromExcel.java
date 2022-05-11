package com.crm.practise;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./data/organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		Cell cel = rw.getCell(0);
		String data = cel.getStringCellValue();
		System.out.println(data);
		wb.close();

		Random ram=new Random();
		int ramint=ram.nextInt(1000);
		
		
		
	}

}
