package com.system.utils.message;

import com.system.domain.WxMessage;
import com.system.domain.WxTemplateMsgRecord;
import com.system.pojo.receiveWxMsg.*;
import com.system.repository.WxMessageRepository;
import com.system.repository.msgTemplateRepository.WxTemplateMsgRecordRepo;
import com.system.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Uni on 2017/11/15.
 */
@Component
public class XmlParseUtil {

    @Autowired
    private WxMessageRepository wxMessageRepository;
    @Autowired
    private TemplateMessageUtil templateMessageUtil;
    @Autowired
    private WxTemplateMsgRecordRepo wxTemplateMsgRecordRepo;

    private static final LoggerUtil logger = new LoggerUtil(XmlParseUtil.class);

    private String temporary_msg_id = "";               //普通消息去重

    private String temporary_event_template = "";     //模板消息去重

    /**
     * 处理微信发来的请求
     * @param request
     * @return xml
     */
    public  WxReceiveMsg receiveXmlParse(HttpServletRequest request) {

        WxReceiveMsg wxReceiveMsg = null;

        // xml格式的消息数据
        String msgId = "";
        String msgID = "";      //模板的msgID
        try {
            // 调用parseXml方法解析请求消息
            Map requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName").toString();
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName").toString();
            // 消息类型
            String msgType = requestMap.get("MsgType").toString();
            //创建时间
            String createTime = requestMap.get("CreateTime").toString();
            //接收到的xml
            String receivexml = requestMap.toString();
            //用户事件去重的临时变量
            String fromUserNameAdCreateTime = fromUserName + createTime;

            //msgId
            if(requestMap.get("MsgId") != null) {
                msgId = requestMap.get("MsgId").toString();
            }
            //模板消息的MsgID
            if(requestMap.get("MsgID") != null) {
                msgID = requestMap.get("MsgID").toString();
            }

//            普通消息和事件模板消息的去重
            if(isEventType(msgType)) {
                String event = requestMap.get("Event").toString();
                if(isTemplateMessage(msgType, requestMap)) {
                    if(temporary_event_template.equals(msgID)) {
                        return wxReceiveMsg;
                    } else {
                        saveTemplateMessage(fromUserName, toUserName,
                                msgType, createTime, receivexml,
                                msgID, requestMap.get("Status").toString());
                    }
                } else {
                    saveMeaage(fromUserName, toUserName, msgType, createTime, receivexml, msgId, event);
                }
            } else {
                if(temporary_msg_id.equals(msgId)) {
                    return wxReceiveMsg;
                } else {
                    saveMeaage(fromUserName, toUserName, msgType, createTime, receivexml, msgId, null);
                    temporary_msg_id = msgId;
                }
            }

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                // 回复文本消息
                WxTextMsg textMessage = new WxTextMsg();
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(createTime);
                textMessage.setMsgType(msgType);
                textMessage.setContent(requestMap.get("Content").toString());
                textMessage.setMsgId(msgId);
                wxReceiveMsg = textMessage;
                textMessage = null;
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                WxImageMsg wxImageMsg = new WxImageMsg();
                wxImageMsg.setToUserName(fromUserName);
                wxImageMsg.setFromUserName(toUserName);
                wxImageMsg.setCreateTime(createTime);
                wxImageMsg.setMsgType(msgType);
                wxImageMsg.setMediaId(requestMap.get("MediaId").toString());
                wxImageMsg.setMsgId(msgId);
                wxReceiveMsg = wxImageMsg;
                wxImageMsg = null;
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                WxVoiceMsg wxVoiceMsg = new WxVoiceMsg();
                wxVoiceMsg.setToUserName(fromUserName);
                wxVoiceMsg.setFromUserName(toUserName);
                wxVoiceMsg.setCreateTime(createTime);
                wxVoiceMsg.setMsgType(msgType);
                wxVoiceMsg.setMediaId(requestMap.get("MediaId").toString());
                wxVoiceMsg.setMsgId(msgId);
                wxReceiveMsg = wxVoiceMsg;
                wxVoiceMsg = null;
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                WxVideoMsg wxVideoMsg = new WxVideoMsg();
                wxVideoMsg.setToUserName(fromUserName);
                wxVideoMsg.setFromUserName(toUserName);
                wxVideoMsg.setCreateTime(createTime);
                wxVideoMsg.setMsgType(msgType);
                wxVideoMsg.setMediaId(requestMap.get("MediaId").toString());
                wxVideoMsg.setMsgId(msgId);
                wxVideoMsg.setThumbMediaId(requestMap.get("ThumbMediaId").toString());
                wxReceiveMsg = wxVideoMsg;
                wxVideoMsg = null;
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                WxLocationMsg wxLocationMsg = new WxLocationMsg();
                wxLocationMsg.setMsgId(msgId);
                wxLocationMsg.setFromUserName(toUserName);
                wxLocationMsg.setToUserName(fromUserName);
                wxLocationMsg.setMsgType(msgType);
                wxLocationMsg.setLocation_X(requestMap.get("Location_X").toString());
                wxLocationMsg.setLocation_Y(requestMap.get("Location_Y").toString());
                wxLocationMsg.setLabel(requestMap.get("Label").toString());
                wxLocationMsg.setScale(requestMap.get("Scale").toString());
                wxReceiveMsg = wxLocationMsg;
                wxLocationMsg = null;
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                WxLinkMsg wxLinkMsg = new WxLinkMsg();
                wxLinkMsg.setFromUserName(toUserName);
                wxLinkMsg.setToUserName(fromUserName);
                wxLinkMsg.setMsgId(msgId);
                wxLinkMsg.setMsgType(msgType);
                wxLinkMsg.setCreateTime(createTime);
                wxLinkMsg.setDescription(requestMap.get("Description").toString());
                wxLinkMsg.setTitle(requestMap.get("Title").toString());
                wxLinkMsg.setUrl(requestMap.get("Url").toString());
                wxReceiveMsg = wxLinkMsg;
                wxLinkMsg = null;
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                WxEventMsg wxEventMsg = new WxEventMsg();
                wxEventMsg.setFromUserName(toUserName);
                wxEventMsg.setToUserName(fromUserName);
                wxEventMsg.setCreateTime(createTime);
                wxEventMsg.setMsgType(msgType);
                // 事件类型
                String eventType = requestMap.get("Event").toString();
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    wxEventMsg.setEvent(eventType);
                }
                // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    wxEventMsg.setEvent(eventType);
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    wxEventMsg.setEvent(eventType);
                    wxEventMsg.setEventKey(requestMap.get("EventKey").toString());
                    wxEventMsg.setTicket(requestMap.get("Ticket").toString());
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    wxEventMsg.setEvent(eventType);
                    wxEventMsg.setLatitude(requestMap.get("Latitude").toString());
                    wxEventMsg.setLongitude(requestMap.get("Longitude").toString());
                    wxEventMsg.setPrecision(requestMap.get("Precision").toString());
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    wxEventMsg.setEvent(eventType);
                    wxEventMsg.setEventKey(requestMap.get("EventKey").toString());
                }
                // 跳转事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
                    wxEventMsg.setEvent(eventType);
                    wxEventMsg.setEventKey(requestMap.get("EventKey").toString());
                }
                else if(eventType.equals(MessageUtil.EVENT_TYPE_TEMPLATE)) {
//                  模板事件消息的推送
                    wxEventMsg.setEvent(eventType);
                    wxEventMsg.setStatus(requestMap.get("Status").toString());
                    String msgIDTemplate = requestMap.get("MsgID").toString();
                    wxEventMsg.setMsgId(msgIDTemplate);
                }
                wxReceiveMsg = wxEventMsg;
                wxEventMsg = null;
            }
        } catch (Exception e) {
            logger.error("解析微信普通消息XML出错",e);
        }
        return wxReceiveMsg;
    }


    /**
     * 判断是否为模板消息
     * @param msgType
     * @param requestMap
     * @return
     */
    public boolean isTemplateMessage(String msgType, Map requestMap) {
        if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
            String eventType = requestMap.get("Event").toString();
            if(eventType.equals(MessageUtil.EVENT_TYPE_TEMPLATE)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断是否是时间消息
     * @param msgType
     * @return
     */
    public boolean isEventType(String msgType) {
        if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
            return true;
        }
        return false;
    }



    /**
     * 保存模板消息
     * @param fromUserName
     * @param toUserName
     * @param msgType
     * @param createTime
     * @param receivexml
     * @param msgID
     * @param status
     */
    public void saveTemplateMessage(String fromUserName, String toUserName,
                            String msgType, String createTime,
                            String receivexml, String msgID, String status) {
            WxTemplateMsgRecord wxTemplateMsgRecord = new WxTemplateMsgRecord();
            wxTemplateMsgRecord.onCreate();
            wxTemplateMsgRecord.setMsgid(msgID);
            wxTemplateMsgRecord.setReceiveXml(receivexml);
            wxTemplateMsgRecord.setStatus(status);
            wxTemplateMsgRecord.setCreateTime(Long.parseLong(createTime));
            wxTemplateMsgRecord.setFromUserName(fromUserName);
            wxTemplateMsgRecord.setToUserName(toUserName);
            wxTemplateMsgRecord.setMsgType(msgType);
            wxTemplateMsgRecordRepo.save(wxTemplateMsgRecord);
    }


    /**
     * 保存正常信息
     * @param fromUserName
     * @param toUserName
     * @param msgType
     * @param createTime
     * @param receivexml
     * @param msgId
     */
    public void saveMeaage(String fromUserName, String toUserName,
                           String msgType, String createTime,
                           String receivexml, String msgId, String event) {
        WxMessage wxMessage = new WxMessage();
        wxMessage.onCreate();
        //保存到wxmessage里
        wxMessage.setFromUserName(fromUserName);
        wxMessage.setToUserName(toUserName);
        wxMessage.setMsgType(msgType);
        wxMessage.setCreateTime(Long.parseLong(createTime));
        wxMessage.setReceiveXml(receivexml);
        wxMessage.setMsgid(msgId);
        wxMessage.setEvent(event);
        wxMessageRepository.save(wxMessage);
    }
}
