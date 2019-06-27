package com.shibo.demo.jpaTest.entity.auditing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_traveler")
@EntityListeners(AuditingEntityListener.class)
public class Traveler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @CreatedBy
    @Column(name = "createUserid")
    private String createUserid;
    @LastModifiedBy
    @Column(name = "lastModifiedUserid")
    private String lastModifiedUserid;
    @CreatedDate
    @Column(name = "createTime")
    private LocalDateTime createTime;
    @LastModifiedDate
    @Column(name = "lastModifiedTime")
    private LocalDateTime lastModifiedTime;
}
