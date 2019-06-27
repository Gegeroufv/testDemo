package com.shibo.demo.jpaTest.entity.intermadiate;

import com.shibo.demo.jpaTest.entity.auditing.AbstractAutitable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "articleCategorySet")
@Setter
@Getter
@Entity
@Table(name = "tb_category")
public class Category extends AbstractAutitable {
    @Column(name = "c_name")
    private String name;
    @Column(name = "c_key")
    private String key;

    @OneToMany(mappedBy = "category")
    private Set<ArticleCategory> articleCategorySet=new HashSet<>();
}
