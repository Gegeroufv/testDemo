package com.shibo.demo.jpaTest.entity.intermadiate;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory,Long> {
    @EntityGraph(value = "Article.all")
    Optional<ArticleCategory> findByArticle_Id(long id);

    @Override
    @EntityGraph(value = "Article.all")
    List<ArticleCategory> findAll();
}
