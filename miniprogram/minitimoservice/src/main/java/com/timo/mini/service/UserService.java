package com.timo.mini.service;

import com.timo.mini.manage.MiniUserData;

/**
 * Created by Uni on 2018/1/12.
 */
public interface UserService {

    /**
     * 返回user by openid
     * @param openId
     * @return
     */
    MiniUserData getUserByOpenId(String openId);

}
