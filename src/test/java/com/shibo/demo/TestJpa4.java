package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.auditing.Traveler;
import com.shibo.demo.jpaTest.entity.auditing.TravelerRepository;
import com.shibo.demo.jpaTest.entity.enumTest.Gender;
import com.shibo.demo.jpaTest.entity.enumTest.User;
import com.shibo.demo.jpaTest.entity.enumTest.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa4 {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TravelerRepository travelerRepository;
    @Test
    public void test1(){
        User user=new User();
        user.setGender(Gender.MAIL);
        user.setName("peace");
        this.userRepository.save(user);
    }

    @Test
    public void test2(){
        //对枚举类的测试
        System.out.println(this.userRepository.findAll());
    }

    @Test
    public void test3(){
        //需要忽略掉主键，否则会查询
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.STARTING))
                //类似于条件的构建，有很多的with
                .withIgnorePaths("id");
        User user=new User();
        user.setName("peace");
        Example<User> ex= Example.of(user,matcher);
        System.out.println(this.userRepository.findAll(ex));
    }

    @Test
    public void test4(){
        Traveler t=new Traveler();
        t.setName("hello");
        t.setAddress("zhengzhou");
        this.travelerRepository.save(t);
    }
}
