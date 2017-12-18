package com.business.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class CoursePojo extends BaseQuery {

    private String courseName;      //课程名称

    private long vocabularyNumber;  //适合词汇量

    private Long activityId;        //活动id

}
