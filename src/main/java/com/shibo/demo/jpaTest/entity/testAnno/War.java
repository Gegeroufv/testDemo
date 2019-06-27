package com.shibo.demo.jpaTest.entity.testAnno;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_war")
public class War {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String warName;
    @Embedded
    //在java中使用的普通工具类
    private Battle battle;
}
