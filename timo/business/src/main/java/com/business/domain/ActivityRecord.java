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
@Table(name = "BUSINESS_ACTIVITY_RECORD")
public class ActivityRecord extends BaseEntity {

    private Long activityId;            //活动id

    private Long userId;                //用户的id

    private Long courseId;              //课程id

}
