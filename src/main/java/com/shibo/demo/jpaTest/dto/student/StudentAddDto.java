package com.shibo.demo.jpaTest.dto.student;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
public class StudentAddDto {
    private String name;
    private Integer age;
    //如果使用Character是{}不是很划算
    private String gender;
}
