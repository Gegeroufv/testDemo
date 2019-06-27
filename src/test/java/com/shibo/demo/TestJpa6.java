package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.testAnno.Battle;
import com.shibo.demo.jpaTest.entity.testAnno.War;
import com.shibo.demo.jpaTest.entity.testAnno.WarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa6 {
    @Autowired
    WarRepository warRepository;

    @Transactional
    @Rollback(false)
    @Test
    public void test1(){
        War war=new War();
        war.setBattle(new Battle("hello", LocalDate.now(),"world"));
        war.setWarName("fuck");
        this.warRepository.save(war);
        System.out.println(this.warRepository.findAll());
    }
}
