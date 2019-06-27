package com.shibo.demo.jpaTest.entity.enumTest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
public enum Gender {
    MAIL("男性"),FMAIL("女性");
    private String name;
}
