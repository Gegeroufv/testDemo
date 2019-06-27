package com.shibo.demo;


import com.shibo.demo.jpaTest.entity.Student;
import com.shibo.demo.jpaTest.repository.StuRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * SimpleJpaRepository这里已经开启了注解
 * 直接使用list进行save就是批量添加
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationApplicationTests {
    @Autowired
    private StuRepo stuRepo;

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    @Test
    @Rollback(false)
    public void contextLoads() {
        //注入对象名称
        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@3c89b864
        //SimpleJpaRepository提供接口的接口实现类
        System.out.println(this.stuRepo);
        //注入对象类型
        //class com.sun.proxy.$Proxy114 代理对象，基于jdk的动态代理创建的
        System.out.println(this.stuRepo.getClass());

    }

    @Test
    public void test1() {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
        //getRepository可以帮助我们生成接口实现类，而这个实现类是SimpleJpaRepository的代理对象
        //要求，该接口必须要继承Repository接口
        StuRepo stuRepo = factory.getRepository(StuRepo.class);
        System.out.println(stuRepo);
        //说明SpringDataJpa也是拿该对象构建接口实现类
        System.out.println(stuRepo.getClass());
    }

    /**
     * Repository
     * 1.基于方法名称命名规则查询
     * findxxandxxx之类的
     * 2.基于@Query注解查询
     */
    @Test
    public void test2() {
        System.out.println(stuRepo.findAll());
        System.out.println("===================================");
        Student stu = this.stuRepo.findBJpql("hello");
        System.out.println(stu);
        List<Student> list = this.stuRepo.findBySql("hello");
        System.out.println(list);
    }

    @Test
    @Transactional
    @Rollback(false)
    //更新必须提添加事务
    public void test3() {
        this.stuRepo.updateByJpql("111", 1);
        this.stuRepo.updateByJpql("222", 2);
        this.stuRepo.updateByJpql("333", 3);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test4() {
        System.out.println();
        Page<Student> page = this.stuRepo.findAll(PageRequest.of(1, 2, new Sort(Sort.Direction.DESC, "name")));
        System.out.println(page);
        System.out.println(page.getContent());
        System.out.println();

    }

    /**
     * 使用JpaSpecificationExecutor<T>接口时必须继承别的jpaRepository接口，否则无法生成代理对象
     */
    @Test
    public void test5() {
        Specification<Student> spec = new Specification<Student>() {
            /**
             * 定义了查询条件
             * @param root select * from t_users 封装了查询条件对象
             * @param query 定义了一个基本的查询,查询了那些字段，排序是什么
             * @param criteriaBuilder 创建一个查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate pre = criteriaBuilder.equal(root.get("name").as(String.class), "111");
//                return pre;
                //注意这种写法！返回的行以及对行的操作！
                return query.where(pre).getRestriction();
            }
        };
        Optional<Student> student = this.stuRepo.findOne(spec);
        System.out.println(student.get());
    }

    @Test
    public void test6(){
        /**
         * select student0_.id as id1_1_, student0_.age as age2_1_, student0_.gender as gender3_1_, student0_.name as name4_1_ from tb_stu student0_ where student0_.name=? order by student0_.name desc limit ?, ?
         * Hibernate: select count(student0_.id) as col_0_0_ from tb_stu student0_ where student0_.name=?
         */
      Page<Student> page=this.stuRepo.findAll(((root, query, criteriaBuilder) -> {
          List<Predicate> predicates=new ArrayList<>();
          if(StringUtils.hasText(root.get("name").toString())){
              predicates.add(criteriaBuilder.equal(root.get("name"),"111"));
          }
          //可以使用cb进行连接操作
          //这里使用的是扫描的行,对结果集进行操作！
          return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
      }),PageRequest.of(0,2,Sort.Direction.DESC,"name"));
        System.out.println(page);
        System.out.println(page.getContent().size());
    }

    /**
     * springdata jpa根据接口实例化来分析接口，接口名加impl
     */
    @Test
    public void test7(){
        //这个是自定义接口
        System.out.println(this.stuRepo.findUserById(1l));
    }
}
/*
 * crud中save方法是没有就添加，有就更新
 * */