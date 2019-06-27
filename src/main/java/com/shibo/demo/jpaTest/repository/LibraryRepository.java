package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
