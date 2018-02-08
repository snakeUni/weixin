package com.timo.mini.manage;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
public class MiniUserData extends BaseQuery {

    private String openId;          //openid

    private String unionId;         //unionId

    private int isMember;          //是否是会员 1:是 0:不是

    private Date memberStartTime;         //会员开始时间

    private Date memberEndTime;            //会员结束时间
}
