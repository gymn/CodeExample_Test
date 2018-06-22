package com.gymn.parsexcel;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hunan
 * @Date 2018/6/15
 * @Time 下午4:02
 */
public class ExampleEventUserModel{
    public void processOneSheet(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader( pkg );
        SharedStringsTable sst = r.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst);

        // 获得第一个sheet
        InputStream sheet2 = r.getSheet("rId1");
        InputSource sheetSource = new InputSource(sheet2);
        parser.parse(sheetSource);
        sheet2.close();
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                        "org.apache.xerces.parsers.SAXParser"
                );
        ContentHandler handler = new SheetHandler(sst,new ArrayList<>());
        parser.setContentHandler(handler);
        return parser;
    }

    /**
     * 处理sax的handler
     */
    private static class SheetHandler extends DefaultHandler {
        private SharedStringsTable sst;
        private String lastContents;
        private boolean nextIsString;

        private List<List<String>> resList;

        private SheetHandler(SharedStringsTable sst, List<List<String>> reslist) {
            this.sst = sst;
            reslist = resList;
        }

        //元素开始时的handler
        @Override
        public void startElement(String uri, String localName, String name,
                                 Attributes attributes) throws SAXException {
            // c => 单元格
            if(name.equals("c")) {
                System.out.print(attributes.getValue("r") + " - ");
                // 获取单元格类型
                String cellType = attributes.getValue("t");
                if(cellType != null && cellType.equals("s")) {
                    nextIsString = true;
                } else {
                    nextIsString = false;
                }
            }
            lastContents = "";
        }

        //元素结束时的handler
        @Override
        public void endElement(String uri, String localName, String name)
                throws SAXException {
            if(nextIsString) {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
                nextIsString = false;
            }

            // v => 单元格内容
            if(name.equals("v")) {
                System.out.println(lastContents);
            }
        }

        //读取元素间内容时的handler
        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            lastContents += new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        ExampleEventUserModel example = new ExampleEventUserModel();
        example.processOneSheet("/Users/hunan/Desktop/推送商户信息10W.xlsx");
    }

}
