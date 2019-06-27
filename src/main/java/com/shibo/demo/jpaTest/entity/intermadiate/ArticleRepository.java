package com.shibo.demo.jpaTest.entity.intermadiate;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long>{
    @EntityGraph(value = "article.all")
    Optional<Article> findById(long id);

}