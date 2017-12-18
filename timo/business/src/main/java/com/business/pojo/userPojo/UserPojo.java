package com.business.pojo.userPojo;

import com.business.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class UserPojo extends BaseQuery{

    private String phone;               //用户的手机号,用于记录信息

    private String openid;              //用户的openid

    private int sex;                    //用户的性别 1:男 2:女

}
