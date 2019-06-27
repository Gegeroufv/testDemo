package com.shibo.demo.jpaTest.annotationTest;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbstractAutitableRepository extends JpaRepository<AbstractAutitable,Long> , JpaSpecificationExecutor<AbstractAutitable> {
    //使用where注解的副作用就是如果查历史删除记录之类的需要使用@query注解自己写sql
    @Query(value = "from AbstractAutitable a where a.removed=true ")
    List<AbstractAutitable> findByRemoved(Boolean removed);
}
