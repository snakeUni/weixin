package com.system.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/12.
 */
@Getter
@Setter
public class WxInfoData extends BaseQuery {

    private String welcome;     //欢迎语

    private String appId;       //appId

    private String appSecret;   //appSecret

    private String token;       //唯一token

    private String wxName;      //微信名称

}
