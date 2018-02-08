package com.timo.mini.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
@Entity
@Table(name = "MINI_USER")
public class MiniUser extends BaseEntity {

    private String openId;          //openid

    private String unionId;         //unionId

    private int isMember;          //是否是会员 1:是 0:不是

    @Temporal(TemporalType.TIMESTAMP)
    private Date memberStartTime;         //会员开始时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date memberEndTime;            //会员结束时间


}
