package co.uk.ybs.selenium.psd2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestData {
	
	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\workspaces\\dataSheet.xlsx";
	
	public static void main(String args[]) {
	
	Map<String, String> dataMap;
	ArrayList<String> arList = new ArrayList<String>();
	Map<Integer, Map<String, String>> testMap = new HashMap();
	
	//public Map<String, String> readExcelData() {
		
		 // Creating a Workbook from an Excel file (.xls or .xlsx)
        try {
			Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
			
			   // Getting the Sheet at index zero
	        Sheet sheet = workbook.getSheetAt(0);

	        // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();
	        
	        // 2. Or you can use a for-each loop to iterate over the rows and columns
	        int recordNum = sheet.getPhysicalNumberOfRows();
	        //for (int i = 1; i<= recordNum ; i++) {
	        int i = 0;
	        int j = 0;
	        System.out.println("number of records :" +sheet.getPhysicalNumberOfRows());
	        //System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
	        for (Row row: sheet) {
	        	dataMap= new HashMap();
	            for(Cell cell: row) {
	            	if (row.getRowNum() == 0) {
	                String rowCellValue = dataFormatter.formatCellValue(cell);
	                arList.add(rowCellValue);
	                } else {
	                	String cellValue = dataFormatter.formatCellValue(cell);
	                	
	                	dataMap.put(arList.get(j), cellValue);
	                	
	                	j++;
	                }
	            	testMap.put( i, dataMap);
	                //System.out.println("arrList : " +arList);
	                //System.out.print(cellValue + "\t");
	               
	               
	            }
	            i++;
	            j=0;
	            
	            //System.out.println();
	            //System.out.print(testMap + "\t");
	        }
	        System.out.print(testMap + "\t");
	        workbook.close(); 
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//}
	
	}
}