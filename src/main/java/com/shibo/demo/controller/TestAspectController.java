package com.shibo.demo.controller;

import com.shibo.demo.aspect.dto.Info;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

@Api("切面测试类")
@RestController
@RequestMapping("/aspect")
public class TestAspectController {
    @ApiOperation("测试替换")
    @PostMapping("/replaceParam")
    public void replaceParam(@RequestBody @Validated Info info){
        System.out.println(info);
    }

    public static void main(String[] args) {
        Object o = new Info();
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(o.getClass());
        Arrays.stream(propertyDescriptors).forEach(e-> {
            System.out.println(e.getName()+" "+e.getValue(e.getName())+" "+e.getPropertyType());
        });
    }
}

