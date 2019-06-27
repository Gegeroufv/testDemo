package com.shibo.demo.jpaTest.controller;

import com.shibo.demo.jpaTest.dto.student.StudentAddDto;
import com.shibo.demo.jpaTest.dto.student.StudentDto;
import com.shibo.demo.jpaTest.dto.student.StudentSearchReqDto;
import com.shibo.demo.jpaTest.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("stu")
@RestController
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation("添加学生")
    @PostMapping("/add")
    //这里记住这里是pay-load的形式接收请求
    public String add(@RequestBody StudentAddDto dto){
        System.out.println(dto);
        this.studentService.save(dto);
        return  "success";
    }

    @GetMapping("/search")
    public List<StudentDto> search(@Validated StudentSearchReqDto dto){
        return this.studentService.search(dto);
    }
}
