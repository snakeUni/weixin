package com.system.pojo.replyWxMsg;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Uni on 2017/11/15.
 */
@Getter
@Setter
public abstract class ReplyMsg implements Serializable {

    private String toUserName;          //接收方帐号（收到的OpenID）

    private String fromUserName;        //开发者微信号

    private String createTime;          //消息创建时间戳

    private String msgType;

}
