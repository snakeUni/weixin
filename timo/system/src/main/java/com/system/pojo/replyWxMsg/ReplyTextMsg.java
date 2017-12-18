package com.system.pojo.replyWxMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/15.
 */
@Getter
@Setter
public class ReplyTextMsg extends ReplyMsg{

    private String content;     //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

}
