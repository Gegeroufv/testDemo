package com.shibo.demo.jpaTest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@ToString(exclude = "emp")
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",length = 100)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Emp emp;
}
