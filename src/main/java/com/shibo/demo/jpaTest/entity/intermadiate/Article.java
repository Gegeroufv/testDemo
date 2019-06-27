package com.shibo.demo.jpaTest.entity.intermadiate;

import com.shibo.demo.jpaTest.entity.auditing.AbstractAutitable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedEntityGraphs(@NamedEntityGraph(
        name = "article.all",
        attributeNodes = {
        @NamedAttributeNode(value = "articleCategorySet",subgraph = "belong.category")},
        subgraphs = {
                @NamedSubgraph(name = "belong.category",attributeNodes = {
                        @NamedAttributeNode("category")
                })
        }
))
@ToString(exclude = "articleCategorySet")
@Setter
@Getter
@Entity
@Table(name = "tb_article")
public class Article extends AbstractAutitable {
    @Column(name = "tile")
    private String title;
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "article")
    private Set<ArticleCategory> articleCategorySet=new HashSet<>();
}
