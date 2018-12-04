package com.beginningdeveloper.maven.NewProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String []args) throws IOException{
		
		String excelPath = "/Users/ethirajp/Downloads/surya.xlsx";
		
		File src=new File(excelPath);
		 
		   // load file
		   FileInputStream fis=new FileInputStream(src);
		 
		   // Load workbook
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		   // Load sheet- Here we are loading first sheet
		      XSSFSheet sh1= wb.getSheetAt(0);
		      
		      int End, start;
		      start = sh1.getFirstRowNum();
				System.out.println(start);

				End = sh1.getLastRowNum();
				System.out.println(End);
				 
				System.out.println(sh1.getPhysicalNumberOfRows());
				
			    int rowCount = sh1.getLastRowNum()-sh1.getFirstRowNum();

			    System.out.println(rowCount);
			    

			    for (int i = 1; i <= rowCount; i++) {

			        Row row = sh1.getRow(i);
			        
			        System.out.print(row.getCell(0).toString());

			        System.out.println();

			    }
	}
}
