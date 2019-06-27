package com.shibo.demo.jpaTest.entity.compositeId;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class UserBlogKey implements Serializable {
    private String title;
    private Integer createUserId;
    private LocalDateTime createTime;
}
