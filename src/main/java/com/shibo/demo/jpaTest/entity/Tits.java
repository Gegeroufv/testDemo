package com.shibo.demo.jpaTest.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;


@Builder
@Entity
@Table(name = "tb_tits")
public class Tits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String shape;
}
