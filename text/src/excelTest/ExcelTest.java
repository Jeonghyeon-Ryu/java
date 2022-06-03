package excelTest;

import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) {
		String version = "xlsx";
		
		Workbook workbook = createWorkbook(version);
		
		Sheet sheet = workbook.createSheet("Test Sheet");
		
		Cell cell = getCell(sheet,0,0);
		cell.setCellValue("Test Result");
		
		cell = getCell(sheet,0,1);
		cell.setCellValue(100);
		
		cell = getCell(sheet,0,2);
		cell.setCellValue(Calendar.getInstance().getTime());
	}

	public static Workbook createWorkbook(String version) {
		if("xls".equals(version)) {
			return new HSSFWorkbook();
		} else if ("xlsx".equals(version)) {
			return new XSSFWorkbook();
		}
		return (Workbook) new NoClassDefFoundError();
	}
	
	public static Cell getCell(Row row, int cellnum) {
		Cell cell = row.getCell(cellnum);
		if(cell==null)
			cell = row.createCell(cellnum);
		return cell;
	}
	
	public static Cell getCell(Sheet sheet, int rownum, int cellnum) {
		Row row = getRow(sheet,rownum);
		return getCell(row,cellnum);
	}
	public static Row getRow(Sheet sheet, int rownum) {
		Row row = sheet.getRow(rownum);
		if(row==null) {
			row = sheet.createRow(rownum);
		}
		return row;
	}
	public void writeExcel(Workbook workbook, String filepath) {
		try (FileOutputStream stream = new FileOutputStream(filepath)) {
			workbook.write(stream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
