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
@Table(name = "BUSINESS_ARTICLE_ANSWER")
public class ArticleAnswer extends BaseEntity {

    private Long questionId;        //题目的id

    private String content;         //题目的内容

    private int correct;            //是否是正确答案 1:正确答案 0:错误答案

}
