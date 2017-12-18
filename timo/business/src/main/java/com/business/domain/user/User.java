package com.business.domain.user;

import com.business.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/27.
 */
@Entity
@Table(name = "USER")
@Getter
@Setter
public class User extends BaseEntity {

    private String phone;               //用户的手机号,用于记录信息

    private String openid;              //用户的openid

    private int sex;                    //用户的性别 1:男 2:女



}
