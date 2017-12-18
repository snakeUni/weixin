package com.system.pojo.menu;

import com.system.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Uni on 2017/11/18.
 */
@Getter
@Setter
public class MenuData extends BaseQuery {

    private String type;        //菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型

    private String name;        //菜单标题，不超过16个字节，子菜单不超过60个字节

    private String key;         //click等点击类型必须,菜单KEY值，用于消息接口推送，不超过128字节

    private String url;         //view、miniprogram类型必须,网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url

    private String media_id;    //media_id类型和view_limited类型必须,调用新增永久素材接口返回的合法media_id

    private String appid;       //miniprogram类型必须,小程序的appid（仅认证公众号可配置）

    private String pagepath;    //小程序的页面路径

    private String subMenu;        //是否是主菜单,主菜单为:button,子菜单为sub_button

    private List<MenuData> sub_menus;

    private MenuData sup_menu;

}
