package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelTestCaseReader extends base {

	public static void main(String[] args) {
		 readExcelx(System.getProperty("user.dir")+"/ExcelFiles/DemoQATest.xlsx");
	}

}
