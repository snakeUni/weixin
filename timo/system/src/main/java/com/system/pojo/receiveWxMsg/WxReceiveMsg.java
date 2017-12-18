package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public  abstract class WxReceiveMsg {

    private String toUserName;      //开发者微信号

    private String fromUserName;    //发送方帐号（一个OpenID)

    private String createTime;        //消息创建时间 （整型)

    private String msgType;         //消息类型，event

    private String msgId;

    private String receiveXml;      //接收到的xml

}
