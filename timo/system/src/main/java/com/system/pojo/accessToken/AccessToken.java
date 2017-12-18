package com.system.pojo.accessToken;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/15.
 */
@Getter
@Setter
public class AccessToken {

    private String access_token;        //access_token

    private long expires_in;             //过期时间

}
