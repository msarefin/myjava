package excelReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReaderWriter {

	private static String filename = System.getProperty("user.dir") + "/Files/excelfile.xlsx";

	public static void main(String[] args) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DataTypesInJava");
		Object[][] datatypes = { { "DataType", "Type", "Bytes" }, { "int", "primitive", 2 },
				{ "float", "primitive", 4 }, { "double", "primitive", 8 }, { "char", "primitive", 1 },
				{ "String", "non-primitive", "no-fixed size" } };

		int rownum = 0;

		for (Object[] datatype : datatypes) {
			Row row = sheet.createRow(rownum++);

			int colnum = 0;

			for (Object field : datatype) {
				Cell cell = row.createCell(colnum++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		try {

			FileOutputStream fos = new FileOutputStream(filename);
			workbook.write(fos);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

		System.out.println("Complete");

	}
}
