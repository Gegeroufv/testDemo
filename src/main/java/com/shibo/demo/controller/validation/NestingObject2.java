package com.shibo.demo.controller.validation;

import lombok.*;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class NestingObject2 {
    @NotBlank(message = "不能为空")
    private String name2;


}
