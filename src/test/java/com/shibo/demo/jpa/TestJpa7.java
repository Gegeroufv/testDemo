package com.shibo.demo.jpa;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa7 {
    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager em;

    @Test
    @Transactional
    public void test1() {
        Query nativeQuery = em.createNativeQuery("select emp.id,emp.name,emp.age,dept.name as 'dept_name'  from tb_employee emp left join tb_department dept on emp.department_id = dept.id");
        List<HashMap> resultList = nativeQuery.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getResultList();
        resultList.stream().collect(Collectors.groupingBy(e -> e.get("age"))).forEach((key, value) -> {
            System.out.println(key);
            for (int i = 0; i < value.size(); i++) {
                System.out.println(value.get(i).get("id") + " " + value.get(i).get("name") + "  " + value.get(i).get("age") + "  " + value.get(i).get("dept_name"));
            }
        });
    }
}
