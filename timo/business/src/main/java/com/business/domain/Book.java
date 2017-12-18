package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/28.
 */
@Getter
@Setter
@Table(name = "BUSINESS_BOOK")
@Entity
public class Book extends BaseEntity {

    private String name;                //书名

    private String author;              //书的作者

    private int price;                  //书本价格

    private String description;         //书本简介

    private int type;                   //书的类别

    private int difficult;              //困难程度  0:入门 1:简单 2:中等 3:困难 4:特别困难

    private Long courseId;              //课程id

}
