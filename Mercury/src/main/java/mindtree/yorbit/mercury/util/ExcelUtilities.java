/**
 * 
 */
package mindtree.yorbit.mercury.util;

import java.io.FileInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author M1044400
 *
 */
public class ExcelUtilities {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	
	private static final Logger log = LogManager.getLogger(ExcelUtilities.class);
	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcel(String workBookName, String SheetName) {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + TestConstants.MERCURY_TEST_DATA_FOLDER + workBookName);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			setExcelWBook(ExcelWBook);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			log.error("file not found");

		}

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum-1).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";

		}

	}

	public static int getRowCount(String sheetName) {
		setExcelWSheet(getExcelWBook().getSheet(sheetName));
		if (getExcelWSheet() != null) {
			int rowCount = getExcelWSheet().getLastRowNum();
			return rowCount+1;
		} else {
			log.warn("Sheet not found");
			return 0;
		}
	}
	
	public static int getColumnCount(String sheetName) {
		setExcelWSheet(getExcelWBook().getSheet(sheetName));
        if (getExcelWSheet() != null){
            Row rowNum = getExcelWSheet().getRow(0);
            int columnCount = rowNum.getLastCellNum();
            return columnCount;
        } else {
            log.warn("Sheet not found");
            return 0;
        }
    }
	public static XSSFWorkbook getExcelWBook() {
		return ExcelWBook;
	}

	public static void setExcelWBook(XSSFWorkbook excelWBook) {
		ExcelWBook = excelWBook;
	}

	public static  Object[][] getDataFromSpreadSheet(final String excelWorkBookName, final String workSheetName)  {
		/*ExcelReader datatable = new ExcelReader(
				System.getProperty("user.dir") + IGlobalConstants.GLOBAL_DATA_FOLDER + excelWorkBookName,
				workSheetName);*/
		setExcel(excelWorkBookName, workSheetName);
		int rowCount = getRowCount(workSheetName);
		System.out.println(rowCount);
		int colCount = getColumnCount(workSheetName);
		Object[][] data = new Object[rowCount - 1][colCount];
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			// loop all the available row values
			for (int colNum = 0; colNum < colCount; colNum++) {
				// while returning the data[][] you should not send the header
				// values
				try {
					data[rowNum - 2][colNum] = getCellData(rowNum, colNum);
				} catch (Exception e) {
					 log.warn("Empty cell");
				}
			}
		}

		return data;
	}
	public static XSSFSheet getExcelWSheet() {
		return ExcelWSheet;
	}

	public static void setExcelWSheet(XSSFSheet excelWSheet) {
		ExcelWSheet = excelWSheet;
	}
}
