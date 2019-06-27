package com.shibo.demo.controller;

import com.shibo.demo.jpaTest.entity.resultName.result1;
import com.shibo.demo.jpaTest.repository.EmpReposiroty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.List;

@RestController
@RequestMapping("/testVo")
public class testVo {
    @Autowired
    EmpReposiroty empReposiroty;

    @PostMapping("/BankNum")
    public TheVo t1(@RequestBody TheVo testVO){
        System.out.println("Hello VO");
        System.out.println(testVO);
        return testVO;
    }

    @GetMapping("/get")
    public void get(){
        List<Tuple> theEmploy = this.empReposiroty.findTheEmploy();
        theEmploy.stream().forEach(e->{
            System.out.println(e);
        });
    }
}
