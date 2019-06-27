package com.shibo.demo.jpaTest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@NamedEntityGraph(name = "RoleGraph",attributeNodes = {
        @NamedAttributeNode(value = "menus")
})

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "menus")
@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.REMOVE)
    //JoinTable:中间表，两侧任意一方就可以
    //joinColumns:建立当前表在中间表中的外键字段
    @JoinTable(name = "t_roles_menus",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menu> menus=new HashSet<>();
}
