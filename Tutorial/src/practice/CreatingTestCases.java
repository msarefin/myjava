package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatingTestCases {
	static String fileLocation = "C:/Users/sunsh/Documents/JavaProject/IdeaProjects/MidTermWeekDays2020/DataTest/AmazonTest.xlsx"; 
	
	public static void main(String[] args) {
		File excelx = new File(fileLocation); 
		
		AppendsExcelx(excelx);
	}
	static void AppendsExcelx(File excelx) {
		if(!excelx.exists()) {
			return; 
		}
		try {
			FileInputStream fis = new FileInputStream(excelx);
			
			XSSFWorkbook xwb = new XSSFWorkbook(excelx); 
			XSSFSheet sheet = xwb.getSheetAt(1); 
			int lastrow = sheet.getLastRowNum(); 
			Row row = sheet.getRow(lastrow); 
			int lastcol = row.getLastCellNum(); 
			for(int i = 0; i<lastcol; i++) {
				System.out.print(row.getCell(i).toString()+"|");
			}
			
			
		} catch (IOException | InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

