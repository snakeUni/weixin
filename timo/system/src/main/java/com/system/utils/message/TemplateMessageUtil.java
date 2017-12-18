package com.system.utils.message;

import com.google.gson.Gson;
import com.system.pojo.messageTemplate.Errorcode;
import com.system.pojo.messageTemplate.WxTemplateList;
import com.system.serviceImpl.accessToken.AccessTokenService;
import com.system.utils.LoggerUtil;
import com.system.utils.menu.MenuUtil;
import com.system.utils.request.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/11/20.
 */
@Component
public class TemplateMessageUtil {

    @Autowired
    private AccessTokenService accessTokenService;

    private final static LoggerUtil logger = new LoggerUtil(TemplateMessageUtil.class);

    private final static String template_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    private final static String template_list_url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";

    private final static String template_delete_url = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";

    public Errorcode wxTemplateMessage(String openid, String templateid, String key) {
        String requestUrl = template_url.replace("ACCESS_TOKEN", accessTokenService.getAccessTokenFromCache().getAccess_token());
        //test用
        String jsonText = "";
        if(key.equals(MenuUtil.my_plan_key)) {
            jsonText = getMyPlanTemplateJsonStr(openid, templateid);
        } else if(key.equals(MenuUtil.day_plan_key)) {
            jsonText = getDayPlanTemplateJsonStr(openid, templateid);
        } else if(key.equals("打卡通知")) {
            jsonText = getPunchTemplateJsonStr(openid, templateid);
        } else if(key.equals(MenuUtil.my_task_key)) {
            jsonText = getTaskTemplateJsonStr(openid, templateid);
        }
        Gson gson = new Gson();
        String result = HttpUtil.sendPostJson(requestUrl, jsonText);
        Errorcode errorcode = gson.fromJson(result, Errorcode.class);
        return  errorcode;
    }

    //我的计划模板替换
    public static String getMyPlanTemplateJsonStr(String openid, String templateid) {
        String jsonText = TemplateMessageFormat.my_plan;
        String engFamous = "There is no love sincerer than the love of food";
        String zhFamous = "没有哪种爱比爱吃更真诚       - 萧伯纳";
        jsonText = jsonText.replace("OPENID", openid).replace("templateId", templateid)
                .replace("famousSentence", engFamous).replace("wordBookName", "MBA商务英语")
                .replace("wordNumber", "3000").replace("wordProgress", "1000/3000")
                .replace("remarkData", zhFamous);
        return jsonText;
    }

   //每日计划模板替换
    public static String getDayPlanTemplateJsonStr(String openid, String templateid) {
        String jsonText = TemplateMessageFormat.day_plan;
        String engFamous = "There is no love sincerer than the love of food";
        String zhFamous = "没有哪种爱比爱吃更真诚       - 萧伯纳";
        jsonText = jsonText.replace("OPENID", openid).replace("templateId", templateid)
                .replace("famousSentence", engFamous).replace("wordTotalNumber", "50")
                .replace("newWordNumber", "20").replace("isComplete", "已完成")
                .replace("remarkData", zhFamous);
        return jsonText;
    }

    //打卡通知模板
    public static String getPunchTemplateJsonStr(String openid, String templateid) {
        String jsonText = TemplateMessageFormat.day_study_notification;
        String engFamous = "There is no love sincerer than the love of food";
        String zhFamous = "没有哪种爱比爱吃更真诚       - 萧伯纳";
        jsonText = jsonText.replace("OPENID", openid).replace("templateId", templateid)
                .replace("famousSentence", engFamous).replace("punchNotification", "少年,该打卡了!!!")
                .replace("endTime", "2017-12-06 23:59").replace("wordTotalNumber", "50")
                .replace("remarkData", zhFamous);
        return jsonText;
    }

    //副本通知模板
    public static String getTaskTemplateJsonStr(String openid, String templateid) {
        String jsonText = TemplateMessageFormat.task_template;
        String taskCondition = "连续背诵一周,测试正确率不低于90%";
        jsonText = jsonText.replace("OPENID", openid).replace("templateId", templateid)
                .replace("taskTitle", "背诵雅思连续一周").replace("taskCondition", taskCondition)
                .replace("taskTime", "2017-12-06 to 2017-12-13").replace("taskProgress", "2/7")
                .replace("taskMoney", "20元").replace("remarkData", "点击查看详情")
                .replace("famousSentence", "");
        return jsonText;
    }


//    获取模板列表
    public WxTemplateList getTemplateList() {
        String access_token = accessTokenService.getAccessTokenFromCache().getAccess_token();
        String request_url = template_list_url.replace("ACCESS_TOKEN", access_token);
        String result = HttpUtil.sendGet(request_url);
        Gson gson = new Gson();
        WxTemplateList wxTemplateList = gson.fromJson(result, WxTemplateList.class);
        return wxTemplateList;
    }

//    删除模板
    public Errorcode deleteTemplate(String templateid) {
        String access_token = accessTokenService.getAccessTokenFromCache().getAccess_token();
        String request_url = template_delete_url.replace("ACCESS_TOKEN", access_token);
        String jsonstr = "{\"template_id\":\"templateId\"}";
        jsonstr = jsonstr.replace("templateId", templateid);
        String result = HttpUtil.sendPostJson(request_url, jsonstr);
        Gson gson = new Gson();
        Errorcode errorcode = gson.fromJson(result, Errorcode.class);
        return errorcode;
    }
}
