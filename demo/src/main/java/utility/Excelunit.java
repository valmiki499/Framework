package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.text.DateFormatter;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Excelunit {
	
	static FileInputStream fin;
	static FileOutputStream fot;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static int rowcount;
	
	//path of excel sheet
	//public static String excelpath ="D:\\ARRA Project\\ARRAtestscript.xlsx"; 
	public static String excelpath ="D:\\valmiki\\Selenium program New\\demo\\data\\ARRAtestscript.xlsx"; 
	
	public static void configexcel(String path, String sheetname) throws Exception
	{
		
			fin=new FileInputStream(path);
			workbook= new XSSFWorkbook(fin);
			sheet=workbook.getSheet(sheetname);
			rowcount=sheet.getLastRowNum();
			System.out.println(rowcount);
	}
	

	public static String Getexceldata(int rownum , int colnum)
	{
		DataFormatter df = new DataFormatter();
		cell=sheet.getRow(rownum).getCell(colnum);
		//String cellvalue=cell.getStringCellValue();
		String cellvalue=df.formatCellValue(cell);
		return cellvalue;
	}
	
	public static void setexceldata(int rownum , int colnum,String path, String status) throws Exception
	{
		
		if(sheet.getRow(rownum)==null)
		{
			sheet.createRow(rownum).createCell(colnum).setCellValue(status);
		}
		else
		{
			sheet.getRow(rownum).createCell(colnum).setCellValue(status);
		}
			fin.close();
			fot=new FileOutputStream(path);
			workbook.write(fot);
			fot.close();
		
	}
	

}
