package excelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFAnchor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFScatterChartData;

import com.google.api.services.sheets.v4.Sheets;

public class ExcelExcelx {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		String xls = "oldExcel.xls";
		CreateExcel(xls);
		updateExcel(xls);
		readExcel(xls);

		System.out.println("-".repeat(100));

		String xlsx = "newExcel.xlsx";
		CreateExcelx(xlsx);
		updateExcelx(xlsx);
		readExcelx(xls);

	}

	private static void createDirectory(String directoryName) {
		File directory = new File(System.getProperty("user.dir") + "/Files/" + directoryName);
		if (directory.exists()) {
			directory.delete();
		}
		if (!directory.exists()) {
			directory.mkdirs();

		}
	}

	// Excel before 2003

	private static void CreateExcel(String excelFile) throws IOException {

		String directoryName = "Excel";
		createDirectory(directoryName);

		File xls = new File(System.getProperty("user.dir") + "/Files/Excel/" + excelFile);
		FileOutputStream fos = new FileOutputStream(xls);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet s = wb.createSheet("The new Sheet");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("When you have eleminated the impossible, what remains however imporbable must be the Truth!");
		wb.write(fos);
		wb.close();
		fos.close();
		System.out.println(excelFile + " Create!");
	}

	private static void updateExcel(String excelFile) throws IOException {
		File xls = new File(System.getProperty("user.dir") + "/Files/Excel/" + excelFile);
		FileInputStream fis = new FileInputStream(xls);

		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet s = wb.getSheet("The new Sheet");
		s.getRow(0).getCell(0).setCellValue("update ");
		fis.close();
		FileOutputStream fos = new FileOutputStream(xls);
		wb.write(fos);
		System.out.println(excelFile + " Updated!");
		System.out.println(s.getLastRowNum());
		
	}

	private static void readExcel(String excelFile) throws IOException {
		File xls = new File(System.getProperty("user.dir") + "/Files/Excel/" + excelFile);
		FileInputStream fis = new FileInputStream(xls);

		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet s = wb.getSheetAt(0);
		String data = s.getRow(0).getCell(0).toString();
		System.out.println(data);
	}

	// Excel after 2003

	private static void CreateExcelx(String ExcelxFile) throws IOException {
		String directory = "Excelx";
		createDirectory(directory);

		File xlsx = new File(System.getProperty("user.dir") + "/Files/Excelx/" + ExcelxFile);
		FileOutputStream fos = new FileOutputStream(xlsx);

		XSSFWorkbook xwb = new XSSFWorkbook();
		XSSFSheet sheet = xwb.createSheet("New Excelx Sheet");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Created using xssfExcel writer in apache poi");
		xwb.write(fos);
		xwb.close();
		fos.close();

	}

	private static void updateExcelx(String ExcelFile) throws InvalidFormatException, IOException {
		File xlsx = new File(System.getProperty("user.dir") + "/Files/Excelx/" + ExcelFile);
		FileInputStream fis = new FileInputStream(xlsx);

		XSSFWorkbook wbx = new XSSFWorkbook(xlsx);
		XSSFSheet sheet = wbx.getSheet("New Excelx Sheet");
		sheet.getRow(0).getCell(0).setCellValue("Created using excel reader for new excel type");
		FileOutputStream fos = new FileOutputStream(xlsx);
		wbx.write(fos);
		wbx.close();
		fos.close();
		fis.close();
	}

	
	private static void readExcelx(String excelFile) throws EncryptedDocumentException, IOException {
		File xlsx = new File(System.getProperty("user.dir")+"/files/Excelx/"+excelFile);
		FileInputStream fis = new FileInputStream(xlsx); 
		
		Workbook workbook = WorkbookFactory.create(fis); 
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		String data = row.getCell(0).toString(); 
		System.out.println(data);
	}
}
