package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Menu;
import com.shibo.demo.jpaTest.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface MenuRepository extends JpaRepository<Menu,Long> {
    Set<Menu> findMenusByRolesIs(Role role);
    @EntityGraph(value = "MenuGraph")
    Menu findById(long id);
}
