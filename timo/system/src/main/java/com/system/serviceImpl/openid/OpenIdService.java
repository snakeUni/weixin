package com.system.serviceImpl.openid;

import com.system.utils.LoggerUtil;
import com.system.utils.request.HttpUtil;

/**
 * Created by Uni on 2017/11/17.
 */
public class OpenIdService {

    public final static String openid_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    private final static LoggerUtil logger = new LoggerUtil(OpenIdService.class);

    public static String getOpenId(String access_token, String openid) {
        String requestUrl = openid_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
        String result = "";
        try {
            result = HttpUtil.sendGet(requestUrl);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return result;
    }
}
