package excelReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithExcel {

	public static void main(String[] args) throws FileNotFoundException {
		
	FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/Files/newExcel.xlsx");
	
	XSSFWorkbook workbook = new XSSFWorkbook(); 
	XSSFSheet sheet = workbook.createSheet("Topics To Learn");
	Row row = sheet.createRow(0); 
	Cell cell = row.createCell(0);
	
	cell.setCellValue("");
		
	}
}
