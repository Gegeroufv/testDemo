package com.shibo.demo.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.imports.ExcelImportService;
import cn.afterturn.easypoi.exception.excel.ExcelImportException;
import com.shibo.demo.excel.EasyPoiUtil;
import com.shibo.demo.excel.ExcelModel;
import com.shibo.demo.excel.test1;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Line;
import javax.validation.constraints.NotNull;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api("")
@RestController
@RequestMapping("/test")
public class testController {
    static info info1;

    @GetMapping("/t")
    public info test1(HttpServletRequest httpServletRequest) {
        info1.setMac(httpServletRequest.getMethod());
        return info1;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class info extends PropertyEditorSupport {
        @NotNull(message = "非空")
        private String mac;
        private String addr;
        private String pcName;
    }

    @PostMapping("/t2")
    public void test2(@Validated @RequestBody info i2) {
        PropertyEditor editorByConvention = BeanUtils.findEditorByConvention(info.class);
        System.out.println(editorByConvention);
        System.out.println(i2);
    }

    @GetMapping("/t3")
    public List<String> test3() {
        return new ArrayList<String>() {{
            add("a1");
            add("b2");
            add("c3");
        }};
    }

    @PostMapping("/up")
    public String upData(@RequestParam("file") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        params.setImportFields(EasyPoiUtil.getHeaders(test1.class));
        List<test1> list = new ArrayList<>();
        try {
            //excel导出功能
            ExcelImportResult<test1> result = ExcelImportUtil.importExcelMore(file.getInputStream(), test1.class, params);
            list = result.getList();
        } catch (ExcelImportException e) {
            e.printStackTrace();
            System.out.println("ExcelImportException");
            return "fail";
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IOException");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception");
        }
        for (test1 t : list) {
            System.out.println(t);
//            System.out.println(new SimpleDateFormat("yyyy-mm-dd").format(t.getTradeDate()));
        }
        return "success";
    }

    @PostMapping("/up2")
    public void upData2(@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<ExcelModel> list = null;
        try {
            //excel导出功能
            ExcelImportResult<ExcelModel> result = ExcelImportUtil.importExcelMore(file.getInputStream(), ExcelModel.class, params);
            list = result.getList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (ExcelModel t : list) {
            System.out.println(t);
            if (t.getTransTime() == null) {
                continue;
            }
            System.out.println(new SimpleDateFormat("yyyy-mm-dd").format(t.getTransTime()));
        }
    }
}
