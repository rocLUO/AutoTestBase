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
 * appiumTest - com.demo
 * author: luopeng
 * Date: 2018/5/24
 * Time: 15:26
 *
 * Description:
 */
public class ExcelUtil {

    public static XSSFSheet excelSheet;
    public static XSSFWorkbook excelBook;
    public static XSSFRow row;
    public static XSSFCell cell;

    /**
     *  加载excel
     * @param path excel文件路径
     */
    public static void setExcelFile(String path) {
        FileInputStream excelFile;

        try {
            excelFile = new FileInputStream(path);
            excelBook = new XSSFWorkbook(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取excel中对应单元格的值
     * @param rownum 行（从0开始）
     * @param cellnum 列（从0开始）
     * @param sheetName sheet名
     * @return
     */
    public static String getCellData(int rownum,int cellnum,String sheetName) {
        excelSheet = excelBook.getSheet(sheetName);
        cell = excelSheet.getRow(rownum).getCell(cellnum);
        String cellData = cell.getStringCellValue();
        return cellData;
    }

    /**
     *  将测试结果写入excel
     * @param result 测试结果
     * @param rownum 行（从0开始）
     * @param cellnum 列（从0开始）
     * @param path excel文件路径
     * @param sheetName sheet名
     */
    public static void setCellData(String result,int rownum,int cellnum,String path,String sheetName) {
        try {
            excelSheet = excelBook.getSheet(sheetName);
            row = excelSheet.getRow(rownum);
            cell = row.getCell(cellnum, row.RETURN_BLANK_AS_NULL);
            if (cell == null) {
                cell = row.createCell(cellnum);
                cell.setCellValue(result);
            } else {
                cell.setCellValue(result);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            excelBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            excelBook = new XSSFWorkbook(new FileInputStream(path));
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 获取excel的sheet的最后一行
     * @param sheetName
     * @return
     */
    public static int getLastRownum(String sheetName) {
        int row = 0;
        try {
            excelSheet = excelBook.getSheet(sheetName);
            row = excelSheet.getLastRowNum();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }


}
