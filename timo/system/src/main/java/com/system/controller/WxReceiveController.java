package com.system.controller;

import com.system.service.WxInfoService;
import com.system.service.menu.MenuService;
import com.system.serviceImpl.replyService.ReplyService;
import com.system.utils.LoggerUtil;
import com.system.utils.message.TemplateMessageUtil;
import com.system.utils.message.XmlParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Uni on 2017/11/12.
 */
@Controller
public class WxReceiveController {

    private final static LoggerUtil logger = new LoggerUtil(WxReceiveController.class);
    @Autowired
    private WxInfoService wxInfoService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private TemplateMessageUtil templateMessageUtil;
    @Autowired
    private XmlParseUtil xmlParseUtil;

    @RequestMapping( value = "/wxReceive", method = RequestMethod.GET)
    public void wxRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //服务器配置
        String signature = req.getParameter("signature"); //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String timestamp = req.getParameter("timestamp"); //时间戳
        String nonce = req.getParameter("nonce"); //随机数
        String echostr = req.getParameter("echostr"); //随机字符串

        String registContent = String.format("signature:%s, timestamp:%s, nonce:%s, echostr:%s", signature, timestamp,
                nonce, echostr);
        logger.info(registContent);
        if (echostr != null)
            resp.getOutputStream().write(echostr.getBytes());
    }

    @RequestMapping(value = "/wxReceive", method = RequestMethod.POST)
    public void wxReceive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 消息的接收、处理、响应
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respXml = replyService.wxReplyMsg(xmlParseUtil.receiveXmlParse(req));
        logger.info("处理微信回复消息");
        // 响应消息
        PrintWriter out = resp.getWriter();
        out.print(respXml);
        out.flush();
        out.close();
    }
}
