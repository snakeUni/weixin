package com.system.service;

import com.system.domain.WxUser;
import com.system.pojo.WxUserData;

/**
 * Created by Uni on 2017/11/13.
 */
public interface WxUserService {

    /**
     * 根据openid
     * @param openid
     * @return
     */
    WxUserData getByOpenid(String openid);

    /**
     * 根据unionid
     * @param unionid
     * @return
     */
    WxUserData getByUnionid(String unionid);

    /**
     * 返回实体方便更新
     * @param openid
     * @return
     */
    WxUser getByOpenId(String openid);

    /**
     * 返回实体方便更新
     * @param unionid
     * @return
     */
    WxUser getByUnionId(String unionid);
}
