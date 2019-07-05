package com.shibo.demo.aspect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Info {
    @NotBlank(message = "not blank!")
    @Length(min = 2, max = 4, message = "must in range")
    private String infoName;
    @NotNull(message = "num must not blank!")
    @Range(max = 2, min = 0, message = "num must in range")
    private Integer num;
    @NotNull(message = "can't be null")
    @Size(min = 2, max = 10, message = "list must in range")
    private List<String> params;
}