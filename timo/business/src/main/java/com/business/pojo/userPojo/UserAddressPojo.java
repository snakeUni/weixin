package com.business.pojo.userPojo;

import com.business.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class UserAddressPojo extends BaseQuery {

    private String addressDetail;       //详细地址

    private String postCode;            //邮编

    private String province;            //省

    private String city;                //城市

    private Long usedId;                //用户id

}
