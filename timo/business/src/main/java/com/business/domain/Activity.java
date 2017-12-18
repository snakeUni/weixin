package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by Uni on 2017/11/27.
 */
@Getter
@Setter
@Entity
@Table(name = "BUSINESS_ACTIVITY")
public class Activity extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;         //活动开始时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;           //活动结束时间

    private String title;           //活动名称

    private String description;     //活动描述

    private int isOpen;             //是否开放

    private int money;              //活动的金额

}
