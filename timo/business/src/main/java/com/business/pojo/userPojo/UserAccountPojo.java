package com.business.pojo.userPojo;

import com.business.domain.user.UserMember;
import com.business.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class UserAccountPojo extends BaseQuery {

    private Long userId;            //用户id;

    private double accountBalance;  //账户余额

    private long accountPoint;      //账户积分

    private UserMember userMember;  //账户等级

}
