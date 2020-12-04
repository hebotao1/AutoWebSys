package com.auto.util;

import com.auto.action.pojo.XiaoDuPojo;
import com.auto.action.pojo.XpathPojo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    public static void main(String[] args) {
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<XiaoDuPojo> list = null;
        String cellData = null;
        String filePath = ".\\src\\main\\resources\\demo1.xlsx";
//        String columns[] = {"name","age","score"};

        wb = readExcel(filePath);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<XiaoDuPojo>();
            //获取第一个sheet
//            sheet = wb.getSheetAt(0);
            sheet =wb.getSheet("sheet1");
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                row = sheet.getRow(i);
                if(row !=null){

                   String key = null;
//                    XpathPojo pojo = new XpathPojo();

                    XiaoDuPojo pojo = new XiaoDuPojo();

                    for (int j=0;j<colnum;j++){

                        cellData = (String) getCellFormatValue(row.getCell(j));
                        if(j==0){  //商品名
                            pojo.setShopName(cellData);
                        }

                        else if(j==1){  //商品详情
                            pojo.setShopDetail(cellData);
                        }
                        else if(j==2){ // 分类1
                            pojo.setShopType1(cellData);
                        }
                        else if(j==3){ // 分类2
                            pojo.setShopType2(cellData);
                        }
                        else if(j==4){ // 规格类型
                            pojo.setPriceType(cellData);
                        }
                        else if(j==5){ // 规格名称
                            pojo.setPriceName(cellData);
                        }
                        else if(j==6){ // 规格价格
                            pojo.setPrice(cellData);
                        }
                        else if(j==7){ // 封面图
                            pojo.setMiniPicture(cellData);
                        }else if(j==8){ // 滑动图
                            pojo.setScollPicture(cellData);
                        }
                        else if(j==9){ // 详情图
                            pojo.setDetailPicture(cellData);
                        }

                    }
                    list.add(pojo);
                }else{
                    break;
                }

            }
        }
    }


    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    //
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }


    //获取表格基本数据
    public static List<XiaoDuPojo>  getXiaoDuShop() {
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<XiaoDuPojo> list = null;
        String cellData = null;
        String filePath =  Thread.currentThread().getContextClassLoader().getResource("demo1.xlsx").getPath();

//        String filePath = ".\\src\\main\\resources\\demo1.xlsx";
//        String columns[] = {"name","age","score"};

        wb = readExcel(filePath);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<XiaoDuPojo>();
            //获取第一个sheet
//            sheet = wb.getSheetAt(0);
            sheet =wb.getSheet("sheet1");
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                row = sheet.getRow(i);
                if(row !=null){

                    XiaoDuPojo pojo = new XiaoDuPojo();

                    for (int j=0;j<colnum;j++){

                        cellData = (String) getCellFormatValue(row.getCell(j));
                        if(j==0){  //商品名
                            pojo.setShopName(cellData);
                        }

                        else if(j==1){  //商品详情
                            pojo.setShopDetail(cellData);
                        }
                        else if(j==2){ // 分类1
                            pojo.setShopType1(cellData);
                        }
                        else if(j==3){ // 分类2
                            pojo.setShopType2(cellData);
                        }
                        else if(j==4){ // 规格类型
                            pojo.setPriceType(cellData);
                        }
                        else if(j==5){ // 规格名称
                            pojo.setPriceName(cellData);
                        }
                        else if(j==6){ // 规格价格
                            pojo.setPrice(cellData);
                        }
                        else if(j==7){ // 封面图
                            pojo.setMiniPicture(cellData);
                        }else if(j==8){ // 滑动图
                            pojo.setScollPicture(cellData);
                        }
                        else if(j==9){ // 详情图
                            pojo.setDetailPicture(cellData);
                        }
                    }
                    list.add(pojo);
                }else{
                    break;
                }
            }
        }
        return list;
    }


}
