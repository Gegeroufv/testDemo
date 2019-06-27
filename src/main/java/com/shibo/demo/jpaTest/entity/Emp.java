package com.shibo.demo.jpaTest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = "department")
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_employee")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "age",length = 3)
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Department department;
}
