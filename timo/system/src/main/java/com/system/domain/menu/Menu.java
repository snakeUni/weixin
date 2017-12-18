package com.system.domain.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.system.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Uni on 2017/11/17.
 */
@Getter
@Setter
@Entity
@Table(name = "WX_MENU")
public class Menu extends BaseEntity {

    private String type;        //菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型

    private String name;        //菜单标题，不超过16个字节，子菜单不超过60个字节

    @Column(name = "keyword")
    private String key;         //click等点击类型必须,菜单KEY值，用于消息接口推送，不超过128字节

    private String url;         //view、miniprogram类型必须,网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url

    private String media_id;    //media_id类型和view_limited类型必须,调用新增永久素材接口返回的合法media_id

    private String appid;       //miniprogram类型必须,小程序的appid（仅认证公众号可配置）

    private String pagepath;    //小程序的页面路径

    private String subMenu;        //是否是主菜单,主菜单为:button,子菜单为sub_button

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sup_menu", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Menu> sub_menus;

    @ManyToOne()
    @JoinColumn(name = "parentId")
    @JsonBackReference
    private Menu sup_menu;


}
