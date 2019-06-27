package com.shibo.demo.jpaTest.entity.enumTest;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    //注意映射的值~！
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
}
