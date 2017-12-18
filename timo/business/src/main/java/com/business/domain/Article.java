package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/27.
 */
@Getter
@Setter
@Entity
@Table(name = "BUSINESS_ARTICLE")
public class Article extends BaseEntity {

    private String englishTitle;        //英文题目

    private String chineseTitle;        //中文标题

    @Column(columnDefinition = "LONGTEXT")
    private String englishContent;     //文章英文内容

    @Column(columnDefinition = "LONGTEXT")
    private String chineseContent;     //文章中文内容

    private String anthor;             //文章作者

    private Long bookId;                //书本id

}
