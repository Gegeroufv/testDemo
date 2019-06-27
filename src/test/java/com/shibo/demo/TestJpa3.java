package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.compositeId.UserBlogEntity;
import com.shibo.demo.jpaTest.entity.compositeId.UserBlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa3 {
    @Autowired
    UserBlogRepository userBlogRepository;

    @Test
    public void test1() {
        UserBlogEntity userBlogEntity = new UserBlogEntity();
        userBlogEntity.setUuid(UUID.randomUUID().toString());
        userBlogEntity.setTitle("hello1");
        userBlogEntity.setCreateUserId(223);
        userBlogEntity.setCreateTime(LocalDateTime.now());
        this.userBlogRepository.save(userBlogEntity);
    }

    @Test
    public void test2(){
        System.out.println(this.userBlogRepository.findAll());
    }

    @Test
    public void test3(){
        this.userBlogRepository.deleteAll();
    }
    @Test
    @Rollback(false)
    @Transactional
    public void test4(){
        //都是先查再删
        this.userBlogRepository.deleteByCreateUserIdAndTitle(223,"hello1");
    }
}
