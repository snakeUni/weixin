package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/29.
 */
@Getter
@Setter
@Table(name = "BUSINESS_COURSE")
@Entity
public class Course extends BaseEntity {

    private String courseName;      //课程名称

    private long vocabularyNumber;  //适合词汇量

    private Long activityId;        //活动id

}
