package com.system.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/12.
 */
@Getter
@Setter
@Entity
@Table(name = "WX_INFO")
public class WxInfo extends BaseEntity {

    private String welcome;     //欢迎语

    private String appId;       //appId

    private String appSecret;   //appSecret

    private String token;       //唯一token

    private String wxName;      //微信名称
}
