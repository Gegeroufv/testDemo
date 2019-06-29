package com.shibo.demo.controller.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NestingObject3 {
    @NotNull(message = "message3")
    private String name3;

    @Valid
    @NotNull(message = "data not null!")
    @Size(min = 1, message = "data size>1")
    List<NestingObject> data = new ArrayList<>();
}
