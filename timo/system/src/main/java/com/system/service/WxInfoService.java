package com.system.service;

import com.system.pojo.WxInfoData;

/**
 * Created by Uni on 2017/11/12.
 */
public interface WxInfoService {

    /**
     * 获取微信信息
     * @param wxName
     * @return
     */
    WxInfoData getByWxName(String wxName);

}
