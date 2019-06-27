package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.intermadiate.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa5 {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ArticleCategoryRepository articleCategoryRepository;

    @Test
    public void test1() {
        Article article = new Article();
        article.setTitle("hello");
        article.setContent("world");
        this.articleRepository.save(article);
        Article article2 = new Article();
        article2.setTitle("hello2");
        article2.setContent("world2");
        this.articleRepository.save(article2);
        Category category = new Category();
        category.setName("c1");
        category.setKey("cc");
        this.categoryRepository.save(category);
        Category category2 = new Category();
        category2.setName("c2");
        category2.setKey("cc");
        this.categoryRepository.save(category2);

        ArticleCategory articleCategory=new ArticleCategory();
        articleCategory.setArticle(article);
        articleCategory.setCategory(category);
        this.articleCategoryRepository.save(articleCategory);
    }
    //https://blog.csdn.net/oyy_90/article/details/80884035
    //https://blog.csdn.net/dalangzhonghangxing/article/details/56680629
    @Test
    public void test2(){
        Optional<Article> optional=this.articleRepository.findById(1l);
        System.out.println(optional.get()+" "+optional.get().getArticleCategorySet());
        optional.get().getArticleCategorySet().stream().forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void test3(){
        Optional<ArticleCategory> articleDetail=this.articleCategoryRepository.findByArticle_Id(1l);
        System.out.println(articleDetail.get());
    }

    @Test
    public void test4(){
        System.out.println(this.articleCategoryRepository.findAll());
    }
    //开启事务之后一次可以拉取出来
    @Transactional(readOnly = true)
    @Test
    public void test5(){
        Optional<Article> article=this.articleRepository.findById(1l);
        System.out.println(article.get());
        article.get().getArticleCategorySet().stream().forEach(e->{
            System.out.println(e);
        });
    }
}
