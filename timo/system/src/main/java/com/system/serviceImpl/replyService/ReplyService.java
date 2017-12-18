package com.system.serviceImpl.replyService;

import com.google.gson.Gson;
import com.system.domain.WxUser;
import com.system.pojo.WxInfoData;
import com.system.pojo.accessToken.AccessToken;
import com.system.pojo.messageTemplate.Errorcode;
import com.system.pojo.receiveWxMsg.WxEventMsg;
import com.system.pojo.receiveWxMsg.WxReceiveMsg;
import com.system.pojo.receiveWxMsg.WxTextMsg;
import com.system.pojo.replyWxMsg.ReplyTextMsg;
import com.system.repository.WxUserRepository;
import com.system.service.WxInfoService;
import com.system.service.WxUserService;
import com.system.serviceImpl.accessToken.AccessTokenService;
import com.system.serviceImpl.openid.OpenIdService;
import com.system.utils.LoggerUtil;
import com.system.utils.menu.MenuUtil;
import com.system.utils.message.MessageUtil;
import com.system.utils.message.TemplateMessageUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/11/15.
 */
@Component
public class ReplyService {

    @Autowired
    private WxUserRepository wxUserRepository;
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private AccessTokenService accessTokenService;
    @Autowired
    private TemplateMessageUtil templateMessageUtil;
    @Autowired
    private WxInfoService wxInfoService;

    private static final LoggerUtil logger = new LoggerUtil(ReplyService.class);

    public  String wxReplyMsg(WxReceiveMsg wxReceiveMsg) {

        String content = "";

        String responseXml = "";

        if(wxReceiveMsg != null) {
            String fromUserName = wxReceiveMsg.getFromUserName();

            String toUserName = wxReceiveMsg.getToUserName();

            String msgType = wxReceiveMsg.getMsgType();

            String createTime = wxReceiveMsg.getCreateTime();

            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                WxTextMsg wxTextMsg = (WxTextMsg) wxReceiveMsg;
                if(wxTextMsg.getContent().equals("打卡通知")) {
                    Errorcode errorcode = templateMessageUtil.wxTemplateMessage(toUserName,"Y4wF5LgQLyPNfzZVWYU1AiL2l7lHplbpDBPRX0TXDSM", "打卡通知");
                }
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {

            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {

            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {

            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {

            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {

            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                WxEventMsg wxEventMsg = (WxEventMsg) wxReceiveMsg;
                String eventType = wxEventMsg.getEvent();
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    WxUser wxUser = wxUserService.getByOpenId(toUserName);
                    if (wxUser != null) {
                        logger.info("用户:" + wxUser.getNickname() + "关注了此公众号");
                        wxUser.setSubscribe(1);
                        wxUserRepository.save(wxUser);
                    } else {
                        AccessToken accessToken = accessTokenService.getAccessTokenFromCache();
                        String result = OpenIdService.getOpenId(accessToken.getAccess_token(), toUserName);
                        Gson gson = new Gson();
                        WxUser wxUser1 = gson.fromJson(result, WxUser.class);
                        if (wxUser1 != null) {
                            wxUserRepository.save(wxUser1);
                            logger.info("用户:" + wxUser1.getNickname() + "关注了此公众号");
                        } else {
                            logger.error("请求用户信息失败,请再次尝试");
                        }
                    }
                    ReplyTextMsg replyTextMsg = new ReplyTextMsg();
                    replyTextMsg.setFromUserName(fromUserName);
                    replyTextMsg.setToUserName(toUserName);
                    replyTextMsg.setMsgType("text");
                    replyTextMsg.setCreateTime(createTime);
                    WxInfoData wxInfoData = wxInfoService.getByWxName("timo");
                    if(wxInfoData != null) {
                        content = StringEscapeUtils.unescapeHtml4(wxInfoData.getWelcome());
                    } else {
                        content = "欢迎客官订阅一约单词公众号\n" +
                                "可通过公众号查看加入副本任务\n" + "查看计划学习英语\n\n" +
                                "<a href = 'www.baidu.com'>一约单词</a>";
                    }

                    replyTextMsg.setContent(content);
                    return MessageUtil.getTextXml(replyTextMsg);

                } else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    WxUser wxUser = wxUserService.getByOpenId(toUserName);
                    if (wxUser != null) {
                        logger.info("用户:" + wxUser.getNickname() + "取消了关注");
                        wxUser.setSubscribe(0);
                        wxUserRepository.save(wxUser);
                    }
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {

                } else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {

                } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {

                    String eventKey = wxEventMsg.getEventKey();
                    getCorrectTemplate(toUserName, eventKey);

                } else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {

                } else if(eventType.equals(MessageUtil.EVENT_TYPE_TEMPLATE)) {

                }
            }
        }
        return responseXml;
    }


    /**
     * 发送模板消息
     * @param toUser
     * @param key
     * @return
     */
    public Errorcode getCorrectTemplate(String toUser, String key) {
        Errorcode errorcode = new Errorcode();
        if(key.equals(MenuUtil.my_plan_key)) {
            errorcode = templateMessageUtil.wxTemplateMessage(toUser, "aqbkGW8lM6InSAK4iq_ZbW7_0AG4YGJOQIqf4GAK1qk", key);
        } else if(key.equals(MenuUtil.day_plan_key)) {
            errorcode = templateMessageUtil.wxTemplateMessage(toUser, "gZx2xx3xXaG-ZtVvv1echtg-zqClzyJNpAXmFt0UCfg", key);
        } else if(key.equals(MenuUtil.my_task_key)) {
            errorcode = templateMessageUtil.wxTemplateMessage(toUser, "mkF3wac1WrudLJlBEYyVgXhPgeBh00Zt3CwQ3jF0uFY", key);
        }
        return errorcode;
    }
}

