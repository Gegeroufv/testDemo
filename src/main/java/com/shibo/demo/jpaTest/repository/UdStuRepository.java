package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "UdStuRepository")
public interface UdStuRepository {
    public Student findUserById(Long id);
}
