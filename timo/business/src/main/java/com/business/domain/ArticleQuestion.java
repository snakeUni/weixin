package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/27.
 */
@Getter
@Setter
@Entity
@Table(name = "BUSINESS_ARTICLE_QUESTION")
public class ArticleQuestion extends BaseEntity {

    private Long articleId;     //对应文章的id

    private String content;     //题目内容

}
