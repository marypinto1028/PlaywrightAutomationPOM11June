

	package utilities;

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtil {

	
	public static String getCellData(String filePath,
	                                 String sheetName,
	                                 int rowNum,
	                                 int colNum) {

	    try {
	        FileInputStream fis = new FileInputStream(filePath);

	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        Row row = sheet.getRow(rowNum);

	        Cell cell = row.getCell(colNum);

	        String value = cell.toString();

	        workbook.close();
	        fis.close();

	        return value;

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return null;
	}

	}
