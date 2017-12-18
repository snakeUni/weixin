package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/10.
 */
@Entity
@Table(name = "WX_CONFIG")
@Getter
@Setter
public class WxInfoConfigEntity extends BaseEntity{

    private String wxToken;         //token

    private String wxName;          //微信名字

    private String access_token;    //微信access_token

    private String app_id;          //微信appId

    private String app_secret;      //微信appSecret

    private String welcome;         //欢迎语
}
