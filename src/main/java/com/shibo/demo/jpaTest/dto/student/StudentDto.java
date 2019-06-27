package com.shibo.demo.jpaTest.dto.student;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
}
