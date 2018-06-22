package com.gymn.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读写csv
 * @Author hunan
 * @Date 2018/6/13
 * @Time 下午8:04
 */
public class TestOpenCsv {
    public static void readCSV() throws Exception{
        File file = new File("");
        CSVReader reader = new CSVReader(new FileReader(file));
        List<String[]> rList = reader.readAll();
        for (String[] sa : rList) {
            for (String s : sa) {
                System.out.println(s+'\n');
            }
            System.out.println();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV() throws Exception{
        CSVWriter writer = new CSVWriter(new FileWriter(new File("")),',');
        List<String[]> alList=new ArrayList<String[]>();
        List<String> list=new ArrayList<String>();
        list.add("a,aa");
        list.add("bb");
        list.add("cc");
        alList.add(list.toArray(new String[list.size()]));

        list=new ArrayList<String>();
        list.add("dd");
        list.add("ee");
        list.add("ff");
        alList.add(list.toArray(new String[list.size()]));

        writer.writeAll(alList);
        writer.close();
    }

    public static void main(String[] args) throws Exception{
       readCSV();
    }
}
