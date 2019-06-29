package com.shibo.demo.controller.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NestingObject {
    @NotBlank
    private String name;
    @Min(value = 1)
    private Integer age;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<NestingObject2> arr=new ArrayList<>();
}
