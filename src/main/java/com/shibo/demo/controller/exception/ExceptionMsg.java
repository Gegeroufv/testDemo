package com.shibo.demo.controller.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionMsg {
    private String code;
    private String exception_name;
    private String msg;
}
