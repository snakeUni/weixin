package com.system.utils.message;

import com.system.pojo.replyWxMsg.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Uni on 2017/11/14.
 */
public class MessageUtil {

    // 请求消息类型：文本
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    // 请求消息类型：图片
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    // 请求消息类型：语音
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    // 请求消息类型：视频
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    // 请求消息类型：地理位置
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    // 请求消息类型：链接
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    // 请求消息类型：事件推送
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    // 事件类型：subscribe(订阅)
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    // 事件类型：unsubscribe(取消订阅)
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    // 事件类型：scan(用户已关注时的扫描带参数二维码)
    public static final String EVENT_TYPE_SCAN = "scan";
    // 事件类型：LOCATION(上报地理位置)
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    // 事件类型：CLICK(自定义菜单拉取消息)
    public static final String EVENT_TYPE_CLICK = "CLICK";
    // 事件类型：CLICK(自定义菜单跳转链接)
    public static final String EVENT_TYPE_VIEW = "VIEW";
    // 模板消息
    public static final String EVENT_TYPE_TEMPLATE = "TEMPLATESENDJOBFINISH";

    // 响应消息类型：文本
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    // 响应消息类型：图片
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    // 响应消息类型：语音
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    // 响应消息类型：视频
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    // 响应消息类型：音乐
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    // 响应消息类型：图文
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return Map
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 扩展xstream使其支持CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                    if(name.equals("createTime")) {
                        cdata = false;
                    }
                }
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * 文本消息对象转换成xml
     *
     * @param replyTextMsg 文本消息对象
     * @return xml
     */
    public static String messageToXml(ReplyTextMsg replyTextMsg) {
        xstream.alias("xml", replyTextMsg.getClass());
        return xstream.toXML(replyTextMsg);
    }

    /**
     * 图片消息对象转换成xml
     *
     * @param imageMessage 图片消息对象
     * @return xml
     */
    public static String messageToXml(ReplyImageMsg imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * 语音消息对象转换成xml
     *
     * @param voiceMessage 语音消息对象
     * @return xml
     */
    public static String messageToXml(ReplyVoiceMsg voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * 视频消息对象转换成xml
     *
     * @param videoMessage 视频消息对象
     * @return xml
     */
    public static String messageToXml(ReplyVideoMsg videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }

    /**
     * 音乐消息转xml
     * @param musicMsg
     * @return
     */
    public static String messageToXml(ReplyMusicMsg musicMsg) {
        xstream.alias("xml", musicMsg.getClass());
        return xstream.toXML(musicMsg);
    }

    /**
     *
     * @param replyMsg
     * @return
     */
    public static String messageToXml(ReplyMsg replyMsg) {
        xstream.alias("xml", replyMsg.getClass());
        return xstream.toXML(replyMsg);
    }

    /**
     * text消息
     * @param replyTextMsg
     * @return
     */
    public static String getTextXml(ReplyTextMsg replyTextMsg) {
        StringBuilder sb = new StringBuilder();
        if(replyTextMsg.getContent().equals("")) {
            return "";
        } else {
            sb.append("<xml>");
            sb.append("<ToUserName><![CDATA["+replyTextMsg.getToUserName()+"]]></ToUserName>");
            sb.append("<FromUserName><![CDATA["+replyTextMsg.getFromUserName()+"]]></FromUserName>");
            sb.append("<CreateTime>"+replyTextMsg.getCreateTime()+"</CreateTime>");
            sb.append("<MsgType><![CDATA["+replyTextMsg.getMsgType()+"]]></MsgType>");
            sb.append("<Content><![CDATA["+replyTextMsg.getContent()+"]]></Content>");
            sb.append("</xml>");
            return sb.toString();
        }
    }
}
