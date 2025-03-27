package com.test.PageObjectModelbasics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DPExcel {
	@DataProvider(name="excelData", parallel = true)
	public Object[][] excelDataProvider() throws IOException{
		Object[][] arrobj=getExcelData("C:\\Users\\yuvar\\git\\TESTNG_JENKINS\\testdata.xlsx", "Sheet1");
		return arrobj;
	}
	
	
	public String[][] getExcelData(String fileName,String sheetName) throws IOException{
		String[][] data=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(0);
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfCols=row.getLastCellNum();
			XSSFCell cell;
			data=new String[noOfRows][noOfCols];
			for(int i=0;i<noOfRows;i++) {
				for(int j=0;j<noOfCols;j++) {
					row=sheet.getRow(i);
					cell=row.getCell(j);
//					data[i-1][j]=cell.getStringCellValue();
					if (cell != null) {
                        data[i][j] = cell.getStringCellValue();
                    } else {
                        data[i][j] = "";
                    }
				}
			}
		}catch (Exception e) {
			System.out.println("The exception is: "+e.getMessage());
		}
		return data;
	}
}
