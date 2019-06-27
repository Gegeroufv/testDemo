package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
