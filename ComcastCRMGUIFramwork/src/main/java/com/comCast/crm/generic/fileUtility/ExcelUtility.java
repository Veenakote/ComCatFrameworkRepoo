package com.comCast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
 public String getDataFromExcel(String sheetname,int rownum,int columnum) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./testData/Testdata.xlsx");
	 Workbook workbook=WorkbookFactory.create(fis);
	 Sheet sheet=workbook.getSheet(sheetname);
	 Row row=sheet.getRow(rownum);
	 Cell cell=row.getCell(columnum);
	 String data=cell.getStringCellValue();
	 return data;
 }
 
 public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./testData/Testdata.xlsx");
	 Workbook workbook=WorkbookFactory.create(fis);
	 Sheet sheet=workbook.getSheet(sheetname);
    int rowcount= sheet.getLastRowNum();
return rowcount;
 }
 public void setDataIntoExcel(String sheetname,int rownum,int columnum,String data) throws Exception
 {
	 FileInputStream fis=new FileInputStream("./testData/Testdata.xlsx");
	 Workbook workbook=WorkbookFactory.create(fis);
	 Sheet sheet=workbook.getSheet(sheetname);
	 sheet.getRow(rownum).createCell(columnum).setCellValue(data);
	 
	 FileOutputStream fos=new FileOutputStream("./testData/Testdata.xlsx");
	 workbook.write(fos);
	 workbook.close();
	 
 }
}
