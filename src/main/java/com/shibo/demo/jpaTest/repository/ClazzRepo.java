package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepo extends JpaRepository<Clazz,Long> {
}
