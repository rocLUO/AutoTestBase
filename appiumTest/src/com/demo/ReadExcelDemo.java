package com.demo;

import jxl.Workbook;
import jxl.read.biff.File;

import java.io.FileInputStream;
import java.io.InputStream;

/*
 * appiumTest - com.demo
 * author: luopeng
 * Date: 2018/5/24
 * Time: 15:22
 *
 * Description:
 */
public class ReadExcelDemo {
	File file = new File("e:\\data.xls"); // 采用的是jxl.jar读取写入表格方式
	InputStream in = new FileInputStream(file); // 新建一可读取本地内容的文件
	Workbook workbook = null;workbook=Workbook.getWorkbook(in); // 获取本地可读取的文件
	mworkbook=workbook;
	Sheet sheet0 = mworkbook.getSheet(0); // 获取第一个sheet表
	int rowLength0 = sheet0.getRows();

	for(
	int k = 0;k<2;k++)
	{ // 测试用例执行的遍数
		for (int i = 1; i < rowLength0; i++) {
			Cell FI = sheet0.getCell(5, i); // 获取sheet0表的第i行第5列
			String strFI = FI.getContents(); // 获取该单元格的内容
			mstrFI = strFI;
			// 定位方式

			Cell GI = sheet0.getCell(6, i);
			String strGI = GI.getContents();
			mstrGI = strGI;
			// 测试对象实体

			Cell HI = sheet0.getCell(7, i);
			String strHI = HI.getContents();
			mstrHI = strHI;
			// 操作方法

			Cell AI = sheet0.getCell(0, i);
			String strAI = AI.getContents();
			mstrAI = strAI;
			// 测试用例ID

			Cell II = sheet0.getCell(8, i);
			String strII = II.getContents();
			mstrII = strII;
		}

	}
}
