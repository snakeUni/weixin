package com.system.pojo.replyWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/15.
 */
@Getter
@Setter
public class ReplyMusicMsg extends ReplyMsg {

    private String title;       //音乐标题

    private String description; //音乐描述

    private String musicURL;    //音乐链接

    private String hqMusicUrl;  //高质量音乐链接，WIFI环境优先使用该链接播放音乐

    private String thumbMediaId;//缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id

}
