package com.system.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/19.
 */
@Getter
@Setter
@Entity
@Table(name = "WX_TEMPLATE_MESSAGE")
public class WxTemplateItem extends BaseEntity {

    private String title;

    @SerializedName("template_id")
    private String templateId;      //模板id

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String primary_industry;

    private String deputy_industry;

    @Column(columnDefinition = "LONGTEXT")
    private String example;

}
