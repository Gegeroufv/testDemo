package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Tits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TitsRepository extends JpaRepository<Tits,Long> , JpaSpecificationExecutor<Tits> {
}
