package com.business.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class ActivityPojo extends BaseQuery {

    private Date startTime;         //活动开始时间

    private Date endTime;           //活动结束时间

    private String title;           //活动名称

    private String description;     //活动描述

    private int isOpen;             //是否开放

    private int money;              //活动的金额

}
