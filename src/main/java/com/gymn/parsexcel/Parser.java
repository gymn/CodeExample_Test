package com.gymn.parsexcel;

import au.com.bytecode.opencsv.CSVWriter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hunan
 * @Date 2018/6/8
 * @Time 下午4:26
 */
public class Parser {
    public static int parseXlsxUsingUserModel() throws Exception {
        System.out.println("开始解析文件");
        long start = System.currentTimeMillis();

        File file = new File("/Users/hunan/Desktop/推送商户信息10W.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb =new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();

        XSSFRow titleRow = sheet.getRow(0);
        int columnNum = titleRow.getPhysicalNumberOfCells();

        List<String[]> content = new ArrayList<>();
        int i=0;
        for (; i < rowNum; i++) {
            String[] sa = new String[columnNum];
            XSSFRow row = sheet.getRow(i);
            if(row.getCell(0)==null){
                break;
            }

            for (int j = 0; j < columnNum; j++) {
                XSSFCell cell = row.getCell(j);
                sa[j] = cell.toString();
            }

            content.add(sa);
        }

        long end = System.currentTimeMillis();
        System.out.println("解析结束，解析时间"+(end-start)*1.0/1000+"s");

        CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(new FileOutputStream("/Users/hunan/Desktop/tuisong.csv"),"GBK"));
        csvWriter.writeAll(content);
        csvWriter.close();

        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(parseXlsxUsingUserModel());
    }
}
