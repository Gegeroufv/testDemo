package com.shibo.demo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.shibo.demo.excel.test1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
@Api("测试2")
@RestController
@RequestMapping("/test2")
public class testDownLoad {
    @GetMapping("/excel")
    public void testexcel(HttpServletResponse response){
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("导入模板", "UTF-8") + ".xls");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("转账记录批量导入", "导入表"), test1.class, new ArrayList<>());
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Data
    private static class TheDto{
        @NotNull(message = "姓名不能为空")
        @Pattern(regexp = "[0-2]{2}")
        private String name;

        private String gender;

        @Min(value = 1,message = "fuck不合法")
        @NotNull(message = "fuck不合法")
        private Integer fuck;
    }

    /**
     * 这里说明如果
     * @param dto
     */
    @ApiOperation("测试validate")
    @PostMapping("/add")
    public void add(@RequestBody @Validated TheDto dto){
        System.out.println(dto);
    }
}
