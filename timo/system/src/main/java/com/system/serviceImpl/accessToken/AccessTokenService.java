package com.system.serviceImpl.accessToken;

import com.google.gson.Gson;
import com.system.pojo.WxInfoData;
import com.system.pojo.accessToken.AccessToken;
import com.system.service.WxInfoService;
import com.system.utils.LoggerUtil;
import com.system.utils.redis.RedisUtil;
import com.system.utils.request.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/15.
 */
@Service
public class AccessTokenService {

    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private final static String access_token = "access_token";

    private final static LoggerUtil logger = new LoggerUtil(AccessTokenService.class);

    @Autowired
    private WxInfoService wxInfoService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取accessToken
     * @param appid
     * @param appsecret
     * @return
     */
    public  AccessToken getAccessToken(String appid, String appsecret) {
        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        String result = HttpUtil.sendGet(requestUrl);
        Gson gson = new Gson();
        AccessToken accessToken = gson.fromJson(result, AccessToken.class);
        redisUtil.set(access_token, accessToken.getAccess_token(), accessToken.getExpires_in()-200);   //设置access_token
        logger.info("存入redis:access_token:" + accessToken.getAccess_token() + "expires_in:" + accessToken.getExpires_in());
        return accessToken;
    }

    /**
     * 从缓存中读取accessToken
     * @return
     */
    public  AccessToken getAccessTokenFromCache() {

//        RedisUtil redisUtil = new RedisUtil();
        AccessToken accessToken = new AccessToken();
        if(redisUtil.get(access_token) != null) {
            logger.info("从缓存读取access_token");
            accessToken.setAccess_token(redisUtil.get(access_token).toString());
            logger.info("从缓存读取成功");
        } else {
            logger.info("重新请求access_token");
            WxInfoData wxInfoData = wxInfoService.getByWxName("timo");
            if(wxInfoData != null) {
                accessToken = getAccessToken(wxInfoData.getAppId(), wxInfoData.getAppSecret());
            } else {
                logger.info("不存在名称为timo的公众号数据");
            }

        }
        return accessToken;
    }
}
