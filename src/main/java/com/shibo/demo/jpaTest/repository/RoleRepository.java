package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Long> {
    @EntityGraph("RoleGraph")
    Role findById(long id);
}
