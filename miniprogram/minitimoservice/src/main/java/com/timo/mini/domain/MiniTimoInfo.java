package com.timo.mini.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
@Entity
@Table(name = "MINI_TIMO_INFO")
public class MiniTimoInfo extends BaseEntity {

    private String appId;           //appid

    private String appSecret;       //appsecret
}
