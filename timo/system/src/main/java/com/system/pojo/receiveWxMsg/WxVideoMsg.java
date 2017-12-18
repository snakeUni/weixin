package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public class WxVideoMsg extends WxReceiveMsg {

    private String mediaId;            //视频消息媒体id，可以调用多媒体文件下载接口拉取数据。

    private String ThumbMediaId;       //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。


}
