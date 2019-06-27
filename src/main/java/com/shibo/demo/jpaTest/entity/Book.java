package com.shibo.demo.jpaTest.entity;

import lombok.*;


import javax.persistence.*;


@ToString(exclude = "lib")
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "page")
    private int page;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Library lib;
}
