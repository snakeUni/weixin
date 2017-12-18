package com.system.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/20.
 */
@Getter
@Setter
@Entity
@Table(name = "WX_TEMPLATE_MESSAGE_RECORD")
public class WxTemplateMsgRecord extends BaseEntity {

    private String toUserName;      //开发者公众号

    private String fromUserName;    //发送方帐号（一个OpenID)

    private long createTime;        //消息创建时间 （整型)

    private String msgType;         //消息类型，event

    private String msgid;             //消息id,用户去重

    @Column(columnDefinition = "LONGTEXT")
    private String receiveXml;      //接收到的xml

    private String status;          //发送状态

}
