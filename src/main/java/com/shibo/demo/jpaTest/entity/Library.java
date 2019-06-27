package com.shibo.demo.jpaTest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString(exclude = "books")
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    //这里mappedBy指的是关系维护的属性,也就是少的一方的属性
    //默认的懒加载就是没有左联
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "lib")
    private Set<Book> books=new HashSet<>();
}
