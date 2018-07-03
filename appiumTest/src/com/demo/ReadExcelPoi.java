/**
 * com.demo
 * appiumTest
 * ReadExcelPoi.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年5月24日 上午11:10:55
 *
 * Created by LuoPeng
 */
package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.appium.TestBase.AppBase;

import io.appium.java_client.AppiumDriver;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 *@author luopeng
 *Last_Update 2018年5月24日上午11:10:55
 *
 */
public class ReadExcelPoi extends testExmple{
	public static void read() throws IOException {

	    //设置Excel文件路径
	    String FileName_TestData = System.getProperty("user.dir") + "\\src\\readExcel.xlsx";

	    FileInputStream ExcelFile;
	    

	    //实例化文件流，相当于打开Excel进程
	    try {

	        ExcelFile = new FileInputStream(FileName_TestData);

	        //实例化ExcelWBook
	        XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);

	        //获取指定的Sheet页
	        XSSFSheet Sheet = ExcelWBook.getSheet("Test");

	        //如果当前Excel文件中没有Test的Sheet页此时Sheet对象中将是空值，为了避免运行时因为异常中止
	        //所以有必要在执行下一步操作之前先判断Sheet是否为空,为空时就打印错误信息
	        if (Sheet != null) {

	            //因为我们需要遍历整个Sheet所有行，所以这里需要先计算整个Sheet有多少行， 之后用循环遍历的方法
	            int lastrow = Sheet.getLastRowNum();

	            for (int i = 1; i <= lastrow; i++) {

	                //读取每行的第一列值当做TS_ID
	                //toString()是将取到的值统一转换成字符
	                //trim()去掉首尾的空格符
	            	String TS_ID = Sheet.getRow(i).getCell(0).getStringCellValue().toString().trim();



	                //读取每行的第二列值当做CaseName
	                String CaseName = Sheet.getRow(i).getCell(1).getStringCellValue().toString().trim();

	                //读取每行的第三列值当做操作方法
	                String Opertion = Sheet.getRow(i).getCell(2).getStringCellValue().toString().trim();

	                //读取每行的第四列值当做测试数据
	                String Data = Sheet.getRow(i).getCell(3).getStringCellValue().toString().trim();

	                System.out.println("测试用例ID===" + TS_ID + "测试名称是====" + CaseName + "操作方法是==" + Opertion + "测试数据是==" + Data);

					if(Opertion == clickId){
//						return AppBase.clickId(Data,Driver);
					}else if(Opertion == clickXpath){
						
					}
	            }

	        }

	        else {

	            System.out.println

	            ("在" + FileName_TestData + "没有找到Sheet名称为Test");

	        }

	    } catch(FileNotFoundException e) {

	        //TODOAuto-generated catch block
	        e.printStackTrace();

	    }

	}

	// 最后我们在Main方法中调用

	public static void main(String[] args) throws IOException {

	    //TODOAuto-generated method stub
	    read();

	}

}
