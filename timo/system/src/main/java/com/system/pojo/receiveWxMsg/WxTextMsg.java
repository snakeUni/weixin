package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public class WxTextMsg extends WxReceiveMsg {

    private String content;         //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）文本消息字段

}
