package utils;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
   
	static XSSFWorkbook	workbook;
	static XSSFSheet sheet ;
	
	public ExcelUtils() {
		try {
		 String projectPath = System.getProperty("user.dir");
		 workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");
		 sheet = workbook.getSheet("Sheet1");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static String getCellDataString(int rowNum, int colNum)  {
	  
		String 	cellData = null;
		
		cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellData;
		//System.out.println(sheet.getRow(1).getCell(1).getNumericCellValue());

	  // old excel format 
	 // HSSFWorkbook workbook2 = new HSSFWorkbook();
	 
	}
	
	public static int getRowCount() {
		  
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of Row:" + rowCount);
        return rowCount;
	 
	}
	
	public static int getColCount() {
		  
		
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of Col:" + colCount);
        return colCount;
	 
	}
}
