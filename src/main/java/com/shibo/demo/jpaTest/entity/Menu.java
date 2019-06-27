package com.shibo.demo.jpaTest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@NamedEntityGraph(name = "MenuGraph",attributeNodes = {
        @NamedAttributeNode(value = "roles")
})

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "roles")
@Entity
@Table(name = "tb_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    //Role那一侧关联的映射对象属性
    @ManyToMany(mappedBy = "menus",cascade = CascadeType.ALL)
    Set<Role> roles=new HashSet<>();
}
