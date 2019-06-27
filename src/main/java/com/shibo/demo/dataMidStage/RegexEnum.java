package com.shibo.demo.dataMidStage;

import lombok.*;

import java.util.regex.Pattern;

@NoArgsConstructor
@AllArgsConstructor
public enum RegexEnum {
    Optional("#\\(.+?\\)+?"),
    Required("$\\(.+?\\)+?"),
    Where("where");
    private String regexStr;

    public Pattern getRegexStr() {
        return Pattern.compile(regexStr);
    }

    public void setRegexStr(String regexStr) {
        this.regexStr = regexStr;
    }
}
