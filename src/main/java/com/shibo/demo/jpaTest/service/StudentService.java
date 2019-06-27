package com.shibo.demo.jpaTest.service;

import com.shibo.demo.jpaTest.dto.student.StudentAddDto;
import com.shibo.demo.jpaTest.dto.student.StudentDto;
import com.shibo.demo.jpaTest.dto.student.StudentSearchReqDto;
import com.shibo.demo.jpaTest.dto.student.StudentSearchResDto;
import com.shibo.demo.jpaTest.entity.Student;
import com.shibo.demo.jpaTest.repository.StuRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StuRepo stuRepo;


    @Transactional
    public void save(StudentAddDto dto){
        Student stu=new Student();
        BeanUtils.copyProperties(dto,stu);
        char[] chars = dto.getGender().toCharArray();
        stu.setGender(chars[0]);
        this.stuRepo.save(stu);
    }

    @Transactional(readOnly = true)
    public List<StudentDto> search(StudentSearchReqDto dto){
        Pageable pageable= PageRequest.of(dto.getPage()-1,dto.getPageSize());
        Page<Student> all = this.stuRepo.findAll(pageable);
        List<Student> content = all.getContent();
        List<StudentDto> stuList=new ArrayList<>();
        StudentDto stu=new StudentDto();
        for(Student student:content){
            stu=new StudentDto();
            BeanUtils.copyProperties(student,stu);
        }
        System.out.println(all.getContent());
        return null;
    }

//    @Transactional(readOnly = true)
//    public List<StudentSearchResDto> searchByCondition(StudentSearchReqDto dto){
//        //
//        Specification<Student> studentSpecification=new Specification<Student>() {
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return null;
//            }
//        }
//    }
}
