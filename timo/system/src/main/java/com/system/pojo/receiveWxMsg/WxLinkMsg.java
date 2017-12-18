package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public class WxLinkMsg extends WxReceiveMsg {

    private String title;       //消息标题

    private String description; //消息描述

    private String url;         //消息链接

}
