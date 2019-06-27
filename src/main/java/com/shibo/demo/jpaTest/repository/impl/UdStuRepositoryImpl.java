package com.shibo.demo.jpaTest.repository.impl;

import com.shibo.demo.jpaTest.entity.Student;
import com.shibo.demo.jpaTest.repository.UdStuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//自定义方法注意命名
public class UdStuRepositoryImpl implements UdStuRepository {
    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager em;

    @Override
    public Student findUserById(Long id) {
        System.out.println("UDRepository");
        return em.find(Student.class,id);
    }
}
