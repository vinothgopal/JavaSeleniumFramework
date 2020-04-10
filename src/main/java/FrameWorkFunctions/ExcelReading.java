package FrameWorkFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	String filepath;
	String TestcaseName;

	public ExcelReading(String filepath, String TestcaseName) {
		this.filepath = filepath;
		this.TestcaseName = TestcaseName;
	}

	@SuppressWarnings("resource")
	public String getData(String SheetName, String coumnName) throws Exception {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		String acvalue = "";
		int k = 0;
		int column = 0;
		int row = 0;
		int m = 1;
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(SheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
				// System.out.println("jj");
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();

				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase(coumnName)) {
						column = k;
						// break;
					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(0).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
						row = m;
						// break;
					}
					m++;
				}

				// System.out.println(row+" uuu"+column);
				acvalue = sheet.getRow(row).getCell(column).getStringCellValue();
				break;
			}
		}
		return acvalue;
		// System.out.println(a);
	}

}
