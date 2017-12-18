package com.system.pojo.receiveWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/14.
 */
@Getter
@Setter
public class WxEventMsg extends WxReceiveMsg {

    private String event;           //事件类型，subscribe(订阅)、unsubscribe(取消订阅)

    private String eventKey;        //事件KEY值，qrscene_为前缀，后面为二维码的参数值

    private String latitude;        //地理位置纬度

    private String longitude;       //地理位置经度

    private String precision;       //地理位置精度

    private String ticket;

    private String status;          //用于模板事件推送

}
