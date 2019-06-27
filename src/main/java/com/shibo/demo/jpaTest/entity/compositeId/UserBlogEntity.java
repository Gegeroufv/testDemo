package com.shibo.demo.jpaTest.entity.compositeId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_userblog")
@IdClass(value = UserBlogKey.class)
public class UserBlogEntity {
    @Column(name = "uuid")
    private String uuid;
    @Id
    @Column(name = "title",nullable = false)
    private String title;
    @Id
    @Column(name = "create_user_id",nullable = false)
    private Integer createUserId;
    @Id
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
}
