package com.shibo.demo.jpa;

import com.shibo.demo.jpaTest.annotationTest.AbstractAutitable;
import com.shibo.demo.jpaTest.annotationTest.AbstractAutitableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testAnnotation {
    @Autowired
    AbstractAutitableRepository abstractAutitableRepository;
    @Test
    @Transactional
    @Rollback(false)
    public void test1(){
        AbstractAutitable abstractAutitable=new AbstractAutitable();
        abstractAutitable.setSucker("hello1");
        this.abstractAutitableRepository.save(abstractAutitable);
    }

    @Test
    @Transactional
    public void test2(){
        System.err.println(this.abstractAutitableRepository.findById(1l).get());
        this.abstractAutitableRepository.findByRemoved(false).stream().forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test3(){
        Optional<AbstractAutitable> abstractAutitable = this.abstractAutitableRepository.findById(2l);
        System.out.println(abstractAutitable.get());
        this.abstractAutitableRepository.delete(abstractAutitable.get());
        this.abstractAutitableRepository.findAll().stream().forEach(e-> System.out.println(e));
    }
}
