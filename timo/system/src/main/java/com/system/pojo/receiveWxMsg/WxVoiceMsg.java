package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public class WxVoiceMsg extends WxReceiveMsg {

    private String mediaId;

    private String format;

}
