package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Student;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

//JpaSpecificationExecutor接口不能单独使用，需要配置Jpa中其他接口一起使用
public interface StuRepo extends JpaRepository<Student,Long>,JpaSpecificationExecutor<Student> ,UdStuRepository{
    @Query(value = "from Student where name= :username ")
    Student findBJpql(String username);

    @Query(value = "select * from tb_stu where name= ?",nativeQuery = true)
    List<Student> findBySql(String username);

    @Query(value = "update Student set name=:username where id=:id")
    @Modifying//说明当前语句是更新语句
    void updateByJpql(String username,long id);
    @CachePut(cacheNames = "name",condition = "#name.length()<=3")
    Student findByName(String name);
}
