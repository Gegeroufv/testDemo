package com.shibo.demo.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class t1export {
    public static void main(String[] args)throws Exception {
//        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("转账记录批量导入","导入表单"),test1.class,new ArrayList(){{
//            add(new test1(1,"11","22","33","44","55","66","77","88",new Date(),100L));
//        }}
//        );
//        FileOutputStream fos=new FileOutputStream("d:/test.xls");
//        workbook.write(fos);
        FileInputStream fis=new FileInputStream("d:/test.xls");
        ImportParams params=new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        params.setNeedSave(true);
        params.setSaveUrl("d:/test/");
        params.setNeedVerfiy(true);
        params.setImportFields(Utils.getHeaders(test1.class));
        List<test1> list= ExcelImportUtil.importExcel(new File("d:/test.xls"),test1.class,params);
//        System.out.println(list.size());
//        System.out.println(list);
//        LongSummaryStatistics result=list.stream().collect(Collectors.summarizingLong(test1::getAmount));
//        System.out.println(result+"   "+result.getClass()+"  "+result.getSum());
        List list2=list.stream().filter(test1 -> {
//            return !(Utils.validation(test1));
            return false;
        }).collect(Collectors.toList());
        System.out.println(list2);
        list.removeAll(list2);
        System.out.println(list);
    }
}
