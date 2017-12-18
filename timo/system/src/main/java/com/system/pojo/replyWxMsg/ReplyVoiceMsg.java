package com.system.pojo.replyWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/15.
 */
@Getter
@Setter
public class ReplyVoiceMsg extends ReplyMsg {

    private String mediaId;     //通过素材管理中的接口上传多媒体文件，得到的id

}
