package com.shibo.demo.jpaTest.entity.intermadiate;

import com.shibo.demo.jpaTest.entity.auditing.AbstractAutitable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedEntityGraphs(@NamedEntityGraph(name = "Article.all",attributeNodes = {
        @NamedAttributeNode("article"),
        @NamedAttributeNode("category")
}))

@ToString
@Getter
@Setter
@Entity
@Table(name = "tb_article_category")
public class ArticleCategory extends AbstractAutitable {
    @ManyToOne
    @JoinColumn
    private Article article;

    @ManyToOne
    @JoinColumn
    private Category category;
}
