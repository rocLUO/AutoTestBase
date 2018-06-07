/**
 * com.demo
 * appiumTest
 * writeExcelPoi.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年5月24日 上午11:34:18
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
 *Last_Update 2018年5月24日上午11:34:18
 *
 */
public class writeExcelPoi {

	public static void TestWrite() throws IOException {

		// 设置Excel文件路径
		String FileName_TestData = System.getProperty("user.dir") + "\\src\\readExcel.xlsx";

		FileInputStream ExcelFile;

		// 实例化文件流，相当于打开Excel进程
		try {

			ExcelFile = new FileInputStream(FileName_TestData);

			// 实例化ExcelWBook
			XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);

			// 获取指定的Sheet页
			XSSFSheet Sheet = ExcelWBook.getSheet("TestWrite");

			// 如果当前Excel文件中没有Test的Sheet页此时Sheet对象中将是空值，为了避免运行时因为异常中止
			// 所以有必要在执行下一步操作之前先判断Sheet是否为空,为空时就打印错误信息
			// 这里需要考量一个问题，如果Sheet名称还没有创建时就需要先创建对应Sheet ,所以代码将要分
			// 成两部分，一部分是Sheet存在，一部分是Sheet不存在的情况
			if (Sheet != null) {

				// 此区块代表Sheet存在的情况
				// 获取最后一行行号，以下代码功能是在最后一行增加记录
				int lastrow = Sheet.getLastRowNum();

				for (int i = 0; i <= lastrow; i++) {
					XSSFRow Row = Sheet.getRow(i);

					// 注意如果指定的行号还没有数据是空白的，Row拿到的值就是null,
					if (Row != null) {

						// 找到指定的单元格
						XSSFCell cell = Row.getCell(0);

						// 先检验单元格的是否存在
						if (cell != null) {

							// 如果单元格存在，此时cell就不为空
							cell.setCellValue("测试用例ID");
						}

						else {

							// 运行到此区块代码该单元格还不存在，需要新建一个单元格
							Row.createCell(0).setCellValue("测试用例ID");
						}
					}
					else {
						XSSFRow Row1 = Sheet.createRow(i);
						XSSFCell cell = Row1.getCell(0);

						// 先检验单元格的是否存在
						if (cell != null) {

							// 如果单元格存在，此时cell就不为空
							cell.setCellValue("测试用例ID");
						}
						else {

							// 运行到此区块代码该单元格还不存在，需要新建一个单元格
							Row1.createCell(0).setCellValue("测试用例ID");
						}
					}
				}
			}
			else {

				// 运行此区块时代表对应Sheet不存在
				XSSFSheet Sheet1 = ExcelWBook.createSheet("TestWrite");
				int lastrow = Sheet1.getLastRowNum();
				for (int i = 0; i <= lastrow; i++) {
					XSSFRow Row = Sheet1.getRow(i);

					// 注意如果指定的行号还没有数据是空白的，Row拿到的值就是null,
					if (Row != null) {

						// 找到指定的单元格
						XSSFCell cell = Row.getCell(0);

						// 先检验单元格的是否存在
						if (cell != null) {

							// 如果单元格存在，此时cell就不为空
							cell.setCellValue("测试用例ID");
						}
						else {

							// 运行到此区块代码该单元格还不存在，需要新建一个单元格
							Row.createCell(0).setCellValue("测试用例ID");
						}
					}
					else {
						XSSFRow Row1 = Sheet1.createRow(i);
						XSSFCell cell = Row1.getCell(0);

						// 先检验单元格的是否存在
						if (cell != null) {

							// 如果单元格存在，此时cell就不为空
							cell.setCellValue("测试用例ID");
						}
						else {

							// 运行到此区块代码该单元格还不存在，需要新建一个单元格
							Row1.createCell(0).setCellValue("测试用例ID");
						}
					}
				}
			}

			// 将数据以文件流的形式写入Excel中
			FileOutputStream fileOut = new FileOutputStream(FileName_TestData);
			ExcelWBook.write(fileOut);
			fileOut.close();

			// 关闭进程
			ExcelFile.close();
		} catch (FileNotFoundException e) {

			// TODOAuto-generated catch block
			e.printStackTrace();
		}
	}

	// 之后在Main方法中调用该方法
	public static void main(String[] args) throws IOException {
		TestWrite();
	}
}
