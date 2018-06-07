/**
 * com.demo
 * appiumTest
 * creatExcel.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年5月24日 上午10:39:43
 *
 * Created by LuoPeng
 */
package com.demo;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 *@author luopeng
 *Last_Update 2018年5月24日上午10:39:43
 *
 */
public class createExcel {
	
	public void createExcelPOI(String Name) throws IOException{
		//创建HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建HSSFSheet对象
		HSSFSheet sheet = wb.createSheet("sheet0");
		//创建HSSFRow对象
		HSSFRow row = sheet.createRow(0);
		//创建HSSFCell对象
		HSSFCell cell=row.createCell(0);
		//设置单元格的值
		cell.setCellValue("单元格中的中文");
		//输出Excel文件
		FileOutputStream output=new FileOutputStream("d:\\test-output\\"+"Name"+".xls");
		output.flush();
		
	}
}
