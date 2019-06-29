package com.shibo.demo.jpa;

import com.shibo.demo.jpaTest.entity.Tits;
import com.shibo.demo.jpaTest.repository.TitsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa8 {
    @Autowired
    TitsRepository titsRepository;

    @Test
    public void test1(){
        ArrayList<Tits> data=new ArrayList(){{
            add(Tits.builder().name("black").shape("huge").build());
            add(Tits.builder().name("white").shape("big").build());
            add(Tits.builder().name("brown").shape("normal").build());
            add(Tits.builder().name("yellow").shape("small").build());
        }};
        this.titsRepository.saveAll(data);
    }

    @Test
    public void test2(){
        Tits black = Tits.builder().name("black").shape("fuck big!").build();
        System.out.println(black);
        this.titsRepository.save(black);
    }
}
