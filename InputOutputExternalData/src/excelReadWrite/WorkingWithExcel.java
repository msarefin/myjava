package excelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithExcel {

	public static void main(String[] args) throws IOException {

//		excel after 2003

//		Create the file
		File xlsx = new File(System.getProperty("user.dir") + "/Files/newExcel.xlsx");
		FileOutputStream fos = new FileOutputStream(xlsx);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Topics To Learn");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Topics to be learned");
		workbook.write(fos);

		workbook.close();

//		update the file
		FileInputStream fis = new FileInputStream(xlsx);
		XSSFWorkbook xwbu = new XSSFWorkbook(fis);
		XSSFSheet xs = xwbu.getSheetAt(0);
		xs.createRow(1).createCell(0).setCellValue("Update excel 2007 sheet");
		FileOutputStream xfos = new FileOutputStream(xlsx);
		xwbu.write(xfos);
		xwbu.close();
		xfos.close();

//		Read excel sheet
		fis = new FileInputStream(xlsx);

		XSSFWorkbook xworkbook = new XSSFWorkbook(fis);
		XSSFSheet xsheet = xworkbook.getSheetAt(0);
		String data = sheet.getRow(0).getCell(0).toString();

		System.out.println(data);

//		-----------------------------------------------------------------

//		excel before 2003

//		reading excel
		File xls = new File(System.getProperty("user.dir") + "/Files/oldExcel.xls");
		fos = new FileOutputStream(xls);

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet s = wb.createSheet("The New Topics");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("This was created in Java");
		wb.write(fos);

		wb.close();

//		updating 2003

		fis = new FileInputStream(xls);
		HSSFWorkbook hwork = new HSSFWorkbook(fis);
		HSSFSheet hsheet = hwork.getSheetAt(0);
		hsheet.createRow(0).createCell(0).setCellValue("Extered for excel 2003");
		FileOutputStream hfos = new FileOutputStream(xls);
		hwork.write(hfos);

//		reading excel

		fis = new FileInputStream(xls);
		HSSFWorkbook wb1 = new HSSFWorkbook(fis);
		HSSFSheet s1 = wb1.getSheetAt(0);
		data = s1.getRow(0).getCell(0).toString();

		System.out.println(data);

	}
}
