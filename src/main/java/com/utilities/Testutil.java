package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

import com.basepage.Basepage;


public class Testutil extends Basepage {	
	public static String path = "C:\\Users\\Vijay\\eclipse-workspace\\com.para\\src\\test\\resources\\Excel1.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] datafromexcel(String Sheetname) throws InvalidFormatException{
		FileInputStream file = null;
		try {
			file=new FileInputStream(path);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(path);
			
		}
		try {
			book= WorkbookFactory.create(file);
		} catch(IllegalFormatException f) {
			f.printStackTrace();			
		} catch(IOException e) {
			e.printStackTrace();			
		}
		sheet=book.getSheet(Sheetname);		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
			
		}		
		return data;
		
	}
	public Testutil() {
		PageFactory.initElements(driver, this);
	}

}
