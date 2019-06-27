package com.shibo.demo.jpaTest.repository;

import com.shibo.demo.jpaTest.entity.Emp;
import com.shibo.demo.jpaTest.entity.resultName.result1;
import com.shibo.demo.jpaTest.projections.EmpProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public interface EmpReposiroty extends JpaRepository<Emp,Long> {
    Collection<EmpProjections> findByNameContains(String str);

    @Query(name = "findTheEmploy",value = "select e.id,e.age,e.name,e.department_id,d.name as department_name from tb_employee e left join tb_department d on e.department_id=d.id",nativeQuery = true)
    List<Tuple> findTheEmploy();
}
