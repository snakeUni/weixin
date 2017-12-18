package com.business.domain.user;

import com.business.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/28.
 */
@Getter
@Setter
@Table(name = "USER_ACCOUNT")
@Entity
public class UserAccount extends BaseEntity {

    private Long userId;            //用户id;

    private double accountBalance;  //账户余额

    private long accountPoint;      //账户积分

    @Enumerated(EnumType.ORDINAL)
    private UserMember userMember;  //账户等级

}
