#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	/**
	 * Take the value from excel file and passing the value to website.
	 * Apache poi Supports to read value from excel file.
	 * Property file Reader(read the data from property file)
	 * 
	 * @author ranjitha.selvam
	 */
	
		
		static Workbook book;
		static Sheet sheet;
	    public static Object[][] getExcel(String path,String sheetName) throws InvalidFormatException {
		File file=new File(path);
		FileInputStream read = null;
		try {
		read = new FileInputStream(file);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		try {
		book = WorkbookFactory.create(file);
		} catch (IOException e) {
		e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int rowCount = 0; rowCount < sheet.getLastRowNum(); rowCount++) {
		for (int cellCount = 0; cellCount < sheet.getRow(0).getLastCellNum(); cellCount++) {
		data[rowCount][cellCount] = sheet.getRow(rowCount + 1).getCell(cellCount).toString();
		}
		}
		return data;
		}
		

  public static String propertyRead(String path,String elements) throws IOException
	{
		Properties properties= new Properties();
		FileInputStream reader=new FileInputStream(path);
		properties.load(reader);
		String data = properties.getProperty(elements);
		return data;
	}

}








