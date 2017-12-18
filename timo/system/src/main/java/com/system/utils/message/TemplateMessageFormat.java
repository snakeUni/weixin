package com.system.utils.message;

/**
 * Created by Uni on 2017/12/3.
 */
public class TemplateMessageFormat {

    //我的计划模板
    public static String my_plan = "{\"touser\":\"OPENID\",\"template_id\":\"templateId\",\"url\":\"http://weixin.qq.com/download\",\"topcolor\":\"#FF0000\",\"data\":{\"first\": {\"value\":\"famousSentence\",\"color\":\"#AAA\"},\"keyword1\": {\"value\":\"wordBookName\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\"wordNumber\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\"wordProgress\",\"color\":\"#173177\"},\"remark\": {\"value\":\"remarkData\",\"color\":\"#AAA\"}}}";

    //每日计划模板
    public static String day_plan = "{\"touser\":\"OPENID\",\"template_id\":\"templateId\",\"url\":\"http://weixin.qq.com\",\"topcolor\":\"#FF0000\",\"data\":{\"first\": {\"value\":\"famousSentence\",\"color\":\"#AAA\"},\"keyword1\": {\"value\":\"wordTotalNumber\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\"newWordNumber\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\"isComplete\",\"color\":\"#173177\"},\"remark\": {\"value\":\"remarkData\",\"color\":\"#AAA\"}}}";

    //打卡通知模板
    public static String day_study_notification = "{\"touser\":\"OPENID\",\"template_id\":\"templateId\",\"url\":\"http://weixin.qq.com\",\"topcolor\":\"#FF0000\",\"data\":{\"first\": {\"value\":\"famousSentence\",\"color\":\"#AAA\"},\"keyword1\": {\"value\":\"punchNotification\",\"color\":\"#000\"},\"keyword2\": {\"value\":\"endTime\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\"wordTotalNumber\",\"color\":\"#173177\"},\"remark\": {\"value\":\"remarkData\",\"color\":\"#AAA\"}}}";

    //副本通知模板
    public static String task_template = "{\"touser\":\"OPENID\",\"template_id\":\"templateId\",\"url\":\"http://weixin.qq.com\",\"topcolor\":\"#FF0000\",\"data\":{\"first\": {\"value\":\"famousSentence\",\"color\":\"#AAA\"},\"keyword1\": {\"value\":\"taskTitle\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\"taskCondition\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\"taskTime\",\"color\":\"#173177\"},\"keyword4\": {\"value\":\"taskProgress\",\"color\":\"#173177\"},\"keyword5\": {\"value\":\"taskMoney\",\"color\":\"#173177\"},\"remark\": {\"value\":\"remarkData\",\"color\":\"#173177\"}}}";

    //活动模板
    public static String activity_template = "{\"touser\":\"OPENID\",\"template_id\":\"templateId\",\"url\":\"\",\"topcolor\":\"#FF0000\",\"data\":{\"first\": {\"value\":\"famousSentence\",\"color\":\"#173177\"},\"keyword1\": {\"value\":\"wordBookName\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\"wordNumber\",\"color\":\"#173177\"},\"keyword3\": {\"value\":\"wordProgress\",\"color\":\"#173177\"}\"remark\": {\"value\":\"remarkData\",\"color\":\"#173177\"}}}";

}
