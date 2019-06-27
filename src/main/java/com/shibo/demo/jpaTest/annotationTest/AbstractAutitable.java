package com.shibo.demo.jpaTest.annotationTest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.time.LocalDateTime;
import java.util.Map;

@ToString
@Getter
@Setter
@Entity
@Table(name = "tb_test_annotation")
//这里where注解可以加，但是sqldelete注解需要自己定义，模仿该方式！#{(T)this.getTableName}
@Where(clause = "removed = 'N'")
//@SQLDelete(sql = "update 123 set removed = 'Y' where id=?")
//测试！！！
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AbstractAutitable {
//    {
//        String tableName = this.getClass().getAnnotation(Table.class).name();
//        System.out.println(tableName);
//        SQLDelete sQLDelete = this.getClass().getAnnotation(SQLDelete.class);
//        InvocationHandler invocationHandler = java.lang.reflect.Proxy.getInvocationHandler(sQLDelete);
//        try {
//            Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
//            memberValues.setAccessible(true);
//            Map o = (Map)memberValues.get(invocationHandler);
//            o.put("sql","update "+tableName+" set removed = 'Y' where id=?");
//            SQLDelete sQLDelete2 = this.getClass().getAnnotation(SQLDelete.class);
//            System.out.println(sQLDelete2.sql());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
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
    //, parameters = {@Parameter(name = "false", value = "0"), @Parameter(name = "true", value = "1")}这里是对一些复杂对象的设置
    @Type(type = "yes_no")
    @Column(name = "removed")
    private Boolean removed = false;

    @Column(name = "sucker")
    private String sucker;

}

