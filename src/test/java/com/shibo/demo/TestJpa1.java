package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.Book;
import com.shibo.demo.jpaTest.entity.Department;
import com.shibo.demo.jpaTest.entity.Emp;
import com.shibo.demo.jpaTest.entity.Library;
import com.shibo.demo.jpaTest.entity.resultName.result1;
import com.shibo.demo.jpaTest.repository.BookRepository;
import com.shibo.demo.jpaTest.repository.DepartmentRepository;
import com.shibo.demo.jpaTest.repository.EmpReposiroty;
import com.shibo.demo.jpaTest.repository.LibraryRepository;
import com.shibo.demo.jpaTest.util.TupleUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Tuple;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa1 {
    @Autowired
    EmpReposiroty empReposiroty;
    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    @Rollback(false)
    @Test
    public void test() {
        //级联关系的建立比如互入
        Emp e1 = new Emp();
        e1.setName("hello1");
        e1.setAge(22);
        Department d1 = new Department();
        d1.setName("world1");
        d1.setEmp(e1);
        e1.setDepartment(d1);
        Emp e2 = new Emp();
        e2.setName("hello2");
        e2.setAge(23);
        Department d2 = new Department();
        d2.setName("world2");
        d2.setEmp(e2);
        e2.setDepartment(d2);
        //在主键维护方插入，且开启级联操作
        this.empReposiroty.save(e1);
        this.empReposiroty.save(e2);
        System.out.println(this.empReposiroty.findAll());
    }

    @Test
    public void test1() {
        Optional<Emp> e1 = this.empReposiroty.findById(1l);
        System.out.println(e1.get() + " " + e1.get().getDepartment());
        Optional<Department> d1 = this.departmentRepository.findById(1l);
        System.out.println(d1.get() + " " + d1.get().getEmp());
    }

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test2() {
        //1.建立对象 2.生成关系
        Library library = new Library();
        library.setName("president");
        library.setDescription("For President!");
        Book book1 = new Book();
        book1.setName("hero");
        book1.setPage(100);
        book1.setDescription("To be a hero");
        Book book2 = new Book();
        book2.setName("soldier");
        book2.setPage(200);
        book2.setDescription("Death!Frighting!");
        library.setBooks(new HashSet() {{
            add(book1);
            add(book2);
        }});
        book1.setLib(library);
        book2.setLib(library);
        this.libraryRepository.save(library);

        book1.setLib(library);
        book2.setLib(library);
        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test3() {
        this.libraryRepository.deleteById(1l);
    }

    @Test
    public void test4() {
        this.bookRepository.findAll().stream().forEach(e -> {
            System.out.println(e + " " + e.getLib());
        });
        //oneToMany端懒加载是拉不出来，所以要求我们必须拉取出来
        //如果进行激进加载，就是连表查询返回结果集
        this.libraryRepository.findAll().stream().forEach(e->{
            System.out.println(e+" "+this.bookRepository.findBooksByLib_Id(e.getId()));
        });
//        this.libraryRepository.findAll().stream().forEach(e->{
//            System.out.println(e+" "+e.getBooks());
//        });
    }
    @Test
    public void test5(){
        this.empReposiroty.findByNameContains("hello").stream().forEach(e->{
            System.out.println(e.getName());
        });
    }

    @Test
    public void test6(){
        result1 result1=new result1();
        List<Tuple> theEmploy = this.empReposiroty.findTheEmploy();
        List<result1> data=new ArrayList<>();
        theEmploy.stream().forEach(tuple -> {
            try {
                result1 o = TupleUtils.convertTupleToBean(tuple, result1.getClass());
                System.out.println(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        List<? extends result1> result1s = TupleUtils.convertTupleToBean(theEmploy, result1.getClass());
        System.out.println(result1s);
    }
}
