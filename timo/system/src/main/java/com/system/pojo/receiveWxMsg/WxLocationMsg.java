package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public class WxLocationMsg extends WxReceiveMsg {

    private String location_X;      //地理位置维度

    private String location_Y;      //地理位置经度

    private String scale;           //地图缩放大小

    private String label;           //地理位置信息

}
