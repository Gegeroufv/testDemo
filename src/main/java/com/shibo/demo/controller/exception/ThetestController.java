package com.shibo.demo.controller.exception;

import com.shibo.demo.jpaTest.entity.Tits;
import com.shibo.demo.jpaTest.repository.TitsRepository;
import com.shibo.demo.utilsTest.beans.Person;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
//这里知道了Spring中的controller是按名注入的，所以不能命名重名
public class ThetestController {
    @Autowired
    TitsRepository titsRepository;

    @PostMapping("/t1")
    public void t1(@RequestBody Person person) {
        Tits black = Tits.builder().name("black").shape("fuck big!").build();
        System.out.println(black);
        this.titsRepository.save(black);
    }
}
