package com.shibo.demo.jpaTest.entity.compositeId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface UserBlogRepository extends JpaRepository<UserBlogEntity,UserBlogKey> {
    void deleteByCreateUserIdAndTitle(Integer userId,String title);
}
