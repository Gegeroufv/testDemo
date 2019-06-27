package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findBooksByLib_Id(Long libId);
}
