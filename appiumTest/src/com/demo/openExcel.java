/**
 * com.demo
 * appiumTest
 * openExcel.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年5月24日 上午11:41:53
 *
 * Created by LuoPeng
 */
package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 *@author luopeng
 *Last_Update 2018年5月24日上午11:41:53
 *
 */
public class openExcel {

	public static void main(String[] args) {
	//method stub

	String Path=System.getProperty("user.dir")+"\\src\\AutoExcel.xlsx";

	String SheetName="Test";
 
	int RowNum=1;

	int ColNum=2;

	String text=getCellData(Path,SheetName,RowNum,ColNum);

	System.out.println("读取的数据是"+text);

	WriteData(Path,"TestWrite",3,5,"自动化测试");

	}

	/**

	*

	*@paramPath

	*@paramSheetName

	*@return

	*@throwsIOException

	*/

	public static int getLastrow(StringPath,StringSheetName)throws IOException {

	int lastrow=0;

	//打开Excel

	File InputStreamOpenExcel=OpenExcel(Path);

	XSSFWorkbook ExcelWBook=ExcelWBook(OpenExcel);

	//获取Sheet

	XSSFSheetExcelWSheet=WriteSheet(ExcelWBook,SheetName);

	lastrow=ExcelWSheet.getLastRowNum();

	OpenExcel.close();

	returnlastrow;

	}

	/**

	*打开Excel文件

	*@paramPath文件路径

	*@return

	*/

	publicstaticFileInputStream

	OpenExcel(String Path){

	//打开Excel进程

	FileInputStreamExcelFile=null;

	try{

	ExcelFile=newFileInputStream(Path);

	}catch(FileNotFoundException e) {

	//TODOAuto-generated

	catch block

	e.printStackTrace();

	}

	returnExcelFile;

	}

	/**

	*

	*@paramExcelFile

	*@return

	*/

	publicstaticXSSFWorkbook ExcelWBook(FileInputStreamExcelFile){

	XSSFWorkbookExcelWBook=null;

	try{

	ExcelWBook=newXSSFWorkbook(ExcelFile);

	}catch(IOException e) {

	//TODOAuto-generated

	catch block

	e.printStackTrace();

	}

	returnExcelWBook;

	}

	publicstaticXSSFSheetGetSheet(XSSFWorkbook ExcelWBook,StringSheetName) {

	XSSFSheetExcelWSheet=null;

	try{

	ExcelWSheet= ExcelWBook.getSheet(SheetName);

	if(ExcelWSheet==null) {

	System.out.println("没有获取到对应的Sheet名称"+SheetName+"请检查Sheet名称是否正确");

	}

	}catch(Exception e) {

	//TODOAuto-generated

	catch block

	e.printStackTrace();

	}

	returnExcelWSheet;

	}

	/**

	*

	*@paramExcelWBook

	*@paramSheetName

	*@return

	*/

	publicstaticXSSFSheet

	WriteSheet(XSSFWorkbook ExcelWBook,String SheetName) {

	XSSFSheetExcelWSheet=null;

	try{

	ExcelWSheet= ExcelWBook.getSheet(SheetName);

	if(ExcelWSheet==null) {

	ExcelWSheet=ExcelWBook.createSheet(SheetName);

	}

	}catch(Exception e) {

	//TODOAuto-generated

	catch block

	e.printStackTrace();

	}

	returnExcelWSheet;

	}

	/**

	*返回指定单元格的数据

	*@paramPath

	*@paramSheetName

	*@paramRowNum

	*@paramColNum

	*@return

	*/

	publicstaticString

	getCellData(String Path,String SheetName,intRowNum,intColNum) {

	//打开Excel

	FileInputStreamOpenExcel=OpenExcel(Path);

	XSSFWorkbookExcelWBook=ExcelWBook( OpenExcel);

	//获取Sheet

	XSSFSheetExcelWSheet=WriteSheet(ExcelWBook,SheetName);

	//获取行号

	XSSFRow Row=WriteRow(ExcelWSheet,RowNum);

	XSSFCellCell;

	StringCellData;

	try{

	//获取单元格的对象

	Cell = Row.getCell(ColNum);

	if(Cell!=null) {

	//取出单元格的值

	CellData= Cell.getStringCellValue();

	}

	else{

	//如果 单元格为空返回"";

	CellData="";

	}

	}catch(Exception e){

	return"";

	}

	returnCellData;

	}

	publicstaticvoidWriteData(String Path,String SheetName,intRowNum,intColNum,String

	Data) {

	//先获取行对象

	try{

	//打开Excel

	FileInputStreamOpenExcel=OpenExcel(Path);

	XSSFWorkbookExcelWBook=ExcelWBook( OpenExcel);

	//获取Sheet

	XSSFSheetExcelWSheet=WriteSheet(ExcelWBook,SheetName);

	//获取行号

	XSSFRowRow=WriteRow(ExcelWSheet, RowNum);

	//获取列号

	XSSFCellCell=WriteCell(Row,ColNum);

	//写入数据

	Cell.setCellValue(Data);

	//保存数据到Excel

	FileOutputStream fileOut =newFileOutputStream(Path);

	ExcelWBook.write(fileOut);

	fileOut.flush();

	fileOut.close();

	}catch(Exception e) {

	System.out.println ("写入操作异常信息是"+e.getMessage());

	}

	}

	/**

	*返回Row对象

	*@paramExcelWSheet

	*@paramRowNum

	*@return

	*/

	publicstaticXSSFRow WriteRow(XSSFSheet ExcelWSheet,intRowNum) {

	XSSFRow Row=null;

	Row= ExcelWSheet.getRow(RowNum);

	if(Row==null){

	Row=ExcelWSheet.createRow(RowNum);

	}

	returnRow;

	}

	/**

	*返回Cell对象

	*@paramRow

	*@paramColNum

	*@return

	*/

	publicstaticXSSFCell WriteCell(XSSFRow Row,intColNum) {

	XSSFCellCell =null;

	Cell= Row.getCell(ColNum);

	if(Cell==null){

	Cell=Row.createCell(ColNum);

	}

	returnCell;

	}

	}

	作者：长新
	链接：https://www.jianshu.com/p/e08b62ae68cd
	來源：简书
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
