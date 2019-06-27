package com.shibo.demo.jpaTest.entity.auditing;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.naming.Name;
import javax.persistence.*;
import java.time.LocalDateTime;

@Where(clause = "removed = 0")
@SQLDelete(sql = "")
@SQLDeleteAll(sql = "")
//测试！！！
@DynamicUpdate(true)
@DynamicInsert(true)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractAutitable {
    {
        //使用代码块获取当前类的信息,获取表名拼接sql,然后放入注解的属性中！需要写demo测试！
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @CreatedDate
    @Column(name = "createTime")
    private LocalDateTime createTime;
    @LastModifiedDate
    @Column(name = "lastModifiedTime")
    private LocalDateTime lastModifiedTime;
    @CreatedBy
    @Column(name = "createBy")
    private String createBy;
    @LastModifiedBy
    @Column(name = "lastModifidBy")
    private String lastModifidBy;
    @Column(name = "removed")
    private Boolean removed = false;
}
