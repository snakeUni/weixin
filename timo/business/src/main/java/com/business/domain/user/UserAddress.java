package com.business.domain.user;

import com.business.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/28.
 */
@Getter
@Setter
@Entity
@Table(name = "USER_ADDRESS")
public class UserAddress extends BaseEntity {

    private String addressDetail;       //详细地址

    private String postCode;            //邮编

    private String province;            //省

    private String city;                //城市

    private Long usedId;                //用户id
}
