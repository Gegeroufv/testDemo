package com.shibo.demo.jpaTest.dto.student;

import lombok.Data;
import javax.validation.constraints.Positive;

@Data
public class StudentSearchReqDto {
    private String name;
    private Integer age;
    private Long id;
    private String gender;
    @Positive
    private Integer page;
    @Positive
    private Integer pageSize;
}
